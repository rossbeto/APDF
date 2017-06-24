package com.xililab.apdf.presentation;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;

import com.xililab.apdf.R;
import com.xililab.apdf.data.IPDFReaderRepository;
import com.xililab.apdf.data.PDFReaderRepository;
import com.xililab.apdf.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


//https://developer.android.com/studio/intro/keyboard-shortcuts.html
public class MainActivity extends AppCompatActivity
{
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        IPDFReaderRepository pdfReaderRepository = new PDFReaderRepository(createParcelFileDescriptor(this));

        PDFDisplayViewModel viewModel = new PDFDisplayViewModel();
        binding.setViewModel(viewModel);
        pdfReaderRepository.openPDFReaderRepository();
        viewModel.setPdfRepository(pdfReaderRepository);
     //   RecyclerView recyclerView = binding.pdfView;

      //  recyclerView.setAdapter(new PDFRecyclerAdapter(pdfReaderRepository));
    }

    private ParcelFileDescriptor createParcelFileDescriptor(Context context)
    {
        final String FILE_NAME = "ielts-writing-task-2-simon-pdf.pdf";
        try
        {
            File file = new File(context.getCacheDir(), FILE_NAME);
            if (!file.exists()) {
                // Since PdfRenderer cannot handle the compressed asset file directly, we copy it into
                // the cache directory.
                InputStream asset = context.getAssets().open(FILE_NAME);
                FileOutputStream output = new FileOutputStream(file);
                final byte[] buffer = new byte[1024];
                int size;
                while ((size = asset.read(buffer)) != -1) {
                    output.write(buffer, 0, size);
                }
                asset.close();
                output.close();
            }

            ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
            return parcelFileDescriptor;
        }
        catch (IOException e )
        {
            e.printStackTrace();
        }
        return null;
    }
}
