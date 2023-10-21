/*

 This file is part of XleTView
 Copyright (C) 2003 Martin SvedÈn

 This is free software, and you are
 welcome to redistribute it under
 certain conditions;

 See LICENSE document for details.

*/


package org.dvb.media;

public interface VideoFormatControl extends javax.media.Control {

    int ASPECT_RATIO_UNKNOWN = -1;

    int ASPECT_RATIO_4_3 = 2;

    int ASPECT_RATIO_16_9 = 3;

    int ASPECT_RATIO_2_21_1 = 4;

    int AFD_NOT_PRESENT = -1;

    int AFD_16_9_TOP = 2;

    int AFD_14_9_TOP = 3;

    int AFD_GT_16_9 = 4;

    int AFD_SAME = 8;

    int AFD_4_3 = 9;

    int AFD_16_9 = 10;

    int AFD_14_9 = 11;

    int AFD_4_3_SP_14_9 = 13;

    int AFD_16_9_SP_14_9 = 14;

    int AFD_16_9_SP_4_3 = 15;

    int DFC_PROCESSING_UNKNOWN = -1;

    int DFC_PROCESSING_NONE = 0;

    int DFC_PROCESSING_FULL = 1;

    int DFC_PROCESSING_LB_16_9 = 2;

    int DFC_PROCESSING_LB_14_9 = 3;

    int DFC_PROCESSING_CCO = 4;

    int DFC_PROCESSING_PAN_SCAN = 5;

    int DFC_PROCESSING_LB_2_21_1_ON_4_3 = 6;

    int DFC_PROCESSING_LB_2_21_1_ON_16_9 = 7;

    int DFC_PLATFORM = 8;

    int DAR_4_3 = 1;

    int DAR_16_9 = 2;

    int getAspectRatio();

    int getActiveFormatDefinition();

    int getDecoderFormatConversion();

    VideoTransformation getVideoTransformation(int dfc);

    int getDisplayAspectRatio();

    boolean isPlatform();

    void addVideoFormatListener(VideoFormatListener l);

    void removeVideoFormatListener(VideoFormatListener l);
}
