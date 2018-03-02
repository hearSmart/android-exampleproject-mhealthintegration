package com.hearxgroup.mhealthintegrationdemo;

import android.content.Intent;

/**
 * Copyright (c) 2017 hearX Group (Pty) Ltd. All rights reserved
 * Created by David Howe on 2018/03/02.
 * hearX Group (Pty) Ltd.
 * info@hearxgroup.com
 */
public class Contract {

    public interface InteractorToPresenterInterface {
        void launch(Intent intent);
    }

    public interface PresenterToUIInterface {
        void launch(Intent intent);
    }
}
