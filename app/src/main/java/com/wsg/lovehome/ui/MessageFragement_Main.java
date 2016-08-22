package com.wsg.lovehome.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.ui.messagelogin.MessageFragment;
import com.wsg.lovehome.ui.messageunlogin.MessageUnLoginFragment;
import com.wsg.lovehome.util.AccessTokenKeeper;

/**
 * Created by wushange on 2016/08/22.
 */
public class MessageFragement_Main extends BaseFragmentV4 {
    private FragmentManager fm;

    @Override
    public void initInjector() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_message_main;
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
    }

    @Override
    public void doBusiness(Context mContext) {
        Logger.e("doBusiness==" + getContext().getClass().getSimpleName());
    }

    @Override
    public void lazyInitBusiness(Context mContext) {
        Logger.e("lazyInitBusiness==" + getContext().getClass().getSimpleName());
        changeStatus();
    }

    private void changeStatus() {
        fm = getFragmentManager();
        if (AccessTokenKeeper.readAccessToken(getContext()).isSessionValid()) {
            fm.beginTransaction().replace(R.id.message_content, new MessageFragment()).commit();
        } else {
            fm.beginTransaction().replace(R.id.message_content, new MessageUnLoginFragment()).commit();
        }
    }

}
