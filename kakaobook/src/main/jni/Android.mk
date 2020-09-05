LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := apiKeystore
LOCAL_SRC_FILES := apiKeystore.c

include $(BUILD_SHARED_LIBRARY)