/*
 *
 * *
 *  Copyright (c) 2016-2018 hearX Group (Pty) Ltd. All rights reserved
 *  Contact info@hearxgroup.com
 *  Created by David Howe
 *  Last modified David Howe on 2018/02/21 10:07 PM
 * /
 */

package com.hearxgroup.mhealthintegrationdemo.TestRetriever.MHealth;

import com.hearxgroup.mhealthintegrationdemo.Models.MHealth.HearscreenTest;

public class MHealthTestRetrieverContract {

    public interface TestRetrieverInterface {
        void onHearscreenRetrieve(HearscreenTest test);
    }
}
