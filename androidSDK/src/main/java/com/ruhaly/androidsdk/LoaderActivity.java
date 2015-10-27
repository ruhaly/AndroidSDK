package com.ruhaly.androidsdk;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;

import com.ruhaly.androidsdk.baseapi.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoaderActivity extends BaseActivity {


    @Override
    public void initData() {

    }

    @Override
    public void initLayout(Bundle paramBundle) {
        setContentView(R.layout.activity_loader);
        ButterKnife.bind(this);

    }

    @Override
    public void initView() {

        CursorLoaderListFragment cursorLoaderListFragment = new CursorLoaderListFragment();
        getFragmentManager().beginTransaction().replace(R.id.root_frame, cursorLoaderListFragment);
    }


    public static class CursorLoaderListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {


        private SimpleCursorAdapter mAdapter;

        String mCurFilter;


        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            mAdapter = new SimpleCursorAdapter(getActivity(),
                    android.R.layout.simple_list_item_2, null,
                    new String[]{ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.Contacts.CONTACT_STATUS},
                    new int[]{android.R.id.text1, android.R.id.text2}, 0);
            setListAdapter(mAdapter);
            getLoaderManager().initLoader(0, null, this);
            super.onActivityCreated(savedInstanceState);
        }

        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            return null;
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {

        }
    }
}
