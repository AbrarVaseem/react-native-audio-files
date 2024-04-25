
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNAudioFilesSpec.h"

@interface AudioFiles : NSObject <NativeAudioFilesSpec>
#else
#import <React/RCTBridgeModule.h>

@interface AudioFiles : NSObject <RCTBridgeModule>
#endif

@end
