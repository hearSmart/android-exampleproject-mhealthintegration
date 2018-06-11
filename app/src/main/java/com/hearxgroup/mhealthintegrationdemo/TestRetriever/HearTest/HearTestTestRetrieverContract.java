/*
 *
 * *
 *  Copyright (c) 2016-2018 hearX Group (Pty) Ltd. All rights reserved
 *  Contact info@hearxgroup.com
 *  Created by David Howe
 *  Last modified David Howe on 2018/02/21 10:07 PM
 * /
 */

package com.hearxgroup.mhealthintegrationdemo.TestRetriever.HearTest;

import com.hearxgroup.mhealthintegrationdemo.Models.HearTest.HearTestTest;

public class HearTestTestRetrieverContract {

    public interface TestRetrieverInterface {
        void onHearTestRetrieve(HearTestTest test);
    }
}
