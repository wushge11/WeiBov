package com.wsg.lovehome.ui.findlogin;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.wsg.lovehome.MainComponent;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.ui.hotweibo.HotWeiBoFragment;
import com.wsg.lovehome.ui.hotweibo.StarWeiBoFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by wushange on 2016/08/16.
 */
public class FindFragment extends BaseFragmentV4 implements FindContract.View {

    @Inject
    FindPresenter presenter;
    @BindView(R.id.data_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.vp_find)
    ViewPager viewPager;

    @Override
    public void initInjector() {
        getComponent(MainComponent.class).inject(this);

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_find_login_view;
    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void doBusiness(Context mContext) {
        Logger.e("doBusiness");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detachView();
    }

    @Override
    public void lazyInitBusiness(Context mContext) {


    }

    @Override
    public void showList() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());

        adapter.addFragment(new HotWeiBoFragment(), "视频");
        adapter.addFragment(new StarWeiBoFragment(), "头条");

        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private final List<BaseFragmentV4> mFragmentList = new ArrayList<BaseFragmentV4>();

        private final List<String> mFragmentTitleList = new ArrayList<String>();

        public ViewPagerAdapter(FragmentManager fm) {

            super(fm);

        }

        @Override

        public BaseFragmentV4 getItem(int position) {

            return mFragmentList.get(position);

        }

        @Override

        public int getCount() {

            return mFragmentList.size();

        }

        @Override

        public CharSequence getPageTitle(int position) {

            return mFragmentTitleList.get(position);

        }

        public void addFragment(BaseFragmentV4 fragment, String title) {

            mFragmentList.add(fragment);

            mFragmentTitleList.add(title);

        }

    }
}
