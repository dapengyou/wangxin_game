#import "WangxinGamePlugin.h"
#if __has_include(<wangxin_game/wangxin_game-Swift.h>)
#import <wangxin_game/wangxin_game-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "wangxin_game-Swift.h"
#endif

@implementation WangxinGamePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftWangxinGamePlugin registerWithRegistrar:registrar];
}
@end
