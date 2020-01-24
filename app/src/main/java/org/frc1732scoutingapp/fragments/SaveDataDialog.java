package org.frc1732scoutingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.frc1732scoutingapp.R;
import org.frc1732scoutingapp.adapters.SaveDialogPagerAdapter;
import org.frc1732scoutingapp.responses.SubmitToDBCallback;

public class SaveDataDialog extends DialogFragment {
    private View view;
    private ImageView qrCodeImage;
    private byte[] codeInBytes;
    private SubmitToDBCallback DBListener;

    public SaveDataDialog(SubmitToDBCallback DBListener) {
        this.DBListener = DBListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_savedatadialog, container, false);
        codeInBytes = getArguments().getByteArray("codeInBytes");
        ViewPager viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new SaveDialogPagerAdapter(getChildFragmentManager(), codeInBytes, DBListener));
        TabLayout dialogTabLayout = view.findViewById(R.id.tabLayout);
        dialogTabLayout.setupWithViewPager(viewPager);
        return view;
    }
}