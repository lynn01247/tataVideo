# TataVideo 简介

### Tata视频，Material Design UI风络，自定义recyclerview，viewpager指示器等  
### 基于ijkplayer开源框架，手动编译移植，mediaplayer的状态机实现左滑控制亮度，右滑控制音量

第一步：整体架构

- 使用viewpager实现启动页面，SharedPreferences保存相关记录

第二步：首页及侧拉菜单模块功能

- 基本框架封装
- Material Design UI风络
- 使用NavigationView + DrawerLayout实现侧拉菜单
- 首页viewpager实现轮播图功能

第三步：列表页模块功能

- viewpager嵌套使用fragment
- 自定义recyclerview（带上拉加载更多，下拉刷新）
- 自定义viewpager指示器
- 数据接口封装
- OkHttp网络请求封装
- Glide图片加载封装
- gson解析数据

第四步：详情页模块功能

- 自定义剧集列表
- 自定义GridView（上拉加载更多）

第五步：播放器模块功能

- 基于Linux手动进行ijkplayer编译及测试
- ijkplayer移植到项目，完美运行
- ijkplayer播放点播视频
- mediaplayer的状态机
- 播放页面电量监听，系统时间显示，playback逻辑处理
- seekbar操作,快进，快退
- Gesturedetector使用，左屏上下滑动调节屏幕亮度，右屏上下滑动调节声音大小，水平滑动调节播放进度

第六步：直播模块功能

- 直播原理、直播相关协议、m3u8介绍
- 15个央视直播加5个卫视直播（高清直播源、稳定有效）
- 部分源画面宽高相等，实现全屏画面播放享受

第七步：收藏模块功能

- 数据库增删操作
- 单选，多选删除

第八步：历史记录模块功能

- 重复造轮子，快速实现功能
- 重构冗余代码，抽取公共模块，剥离差异化部分