/** 排课结果 */

	/** 排课结果Id   */ private Integer schedId   ;
	/** 排课计划Id   */ private Integer scpId     ;
	/** 课表类型     */ private Byte    type      ; //1来自排课方案(默认)、2来自任课表、3即时课表
	/** 排课方案Id   */ private Integer scpSId    ;
	/** 课表缓冲Id   */ private Integer schBufId  ;
	/** 教师任课Id   */ private Integer thrCouId  ;
	/** 教师Id       */ private Integer thrId     ;
	/** 课程Id       */ private Integer couId     ;
	/** 行政班Id     */ private Integer claId     ;
	/** 教学班Id     */ private Integer tccId     ;
	/** 场地Id       */ private Integer romId     ;
	/** 开课周       */ private Integer weekHave  ;
	/** 周课表       */ private Long    weekSched ;
	/** 周课时       */ private Byte    weekLesNum;
	/** 开课类型     */ private Integer couType   ; //代码类型11
	/** 学分         */ private Double  credit    ;

	/** 教师编号       */ private String  thrNO     ;
	/** 教师姓名       */ private String  thrName   ;
	/** 教师性别       */ private String  thrSex    ;
	/** 课程编号       */ private String  couNO     ;
	/** 课程名称       */ private String  couName   ;
	/** 班级编号       */ private String  claNO     ;
	/** 班级名称       */ private String  claName   ;
	/** 年级代码       */ private Integer claGrade  ; //代码类型(35)
	/** 专业代码       */ private Integer claMajor  ; //代码类型(3)
	/** 校区Id         */ private Integer claCamId  ;
	/** 学部Id         */ private Integer claDepId  ;
	/** 教学班编号     */ private String  tccNO     ;
	/** 教学班名称     */ private String  tccName   ;
	/** 教学班年级     */ private Integer tccGrade  ; //系统代码35
	/** 教学班专业     */ private Integer tccMajor  ; //系统代码3
	/** 教学班校区Id   */ private Integer tccCamId  ;
	/** 教学班学部Id   */ private Integer tccDepId  ;
	/** 场地名称       */ private String  romName   ;
	/** 教学楼         */ private Integer romBuiId  ;
	/** 教学楼名称     */ private String  romBuiName;
	/** 排课计划明细Id */ private Integer scpDId    ;
	/** 方案分组       */ private Byte    scmGrp    ;

	/** 排序字段       */ private String[] orderFd    ; //排序字段的名称，倒序前面加“@”，可以多个
	/** 排课结果Id(组) */ private String   schedIds   ; //多个用“,”隔开
    /** 位化课表       */ private String   bitStrSched;
    /** 位化开课周     */ private String   bitStrWeekH;
    /** 名单来源       */ private Byte     memSrc     ;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：
	 *
	 * URL：schedule!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * schedId      可选   排课结果Id
	 * scpId        可选   排课计划Id
	 * type         可选   课表类型 1来自排课方案(默认)、2来自任课表、3即时课表
	 * scpSId       可选   排课方案Id
	 * schBufId     可选   课表缓冲Id
	 * thrCouId     可选   教师任课Id
	 * thrId        可选   教师Id
	 * couId        可选   课程Id
	 * claId        可选   行政班Id
	 * tccId        可选   教学班Id
	 * romId        可选   场地Id
	 * weekHave     可选   开课周
	 * weekSched    可选   周课表
	 * weekLesNum   可选   周课时
	 * couType      可选   开课类型 代码类型11
	 * credit       可选   学分
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[Schedule]}
	 *
	 */

	//==================================================================================================================
	// 查询2 -- 引入：成员名称
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询2 -- 引入：成员名称
	 * 使用者：
	 *
	 * URL：schedule!query2.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * schedId      可选   排课结果Id
	 * scpId        可选   排课计划Id
	 * type         可选   课表类型 1来自排课方案(默认)、2来自任课表、3即时课表
	 * scpSId       可选   排课方案Id
	 * schBufId     可选   课表缓冲Id
	 * thrCouId     可选   教师任课Id
	 * thrId        可选   教师Id
	 * couId        可选   课程Id
	 * claId        可选   行政班Id
	 * tccId        可选   教学班Id
	 * romId        可选   场地Id
	 * weekHave     可选   开课周
	 * weekSched    可选   周课表
	 * weekLesNum   可选   周课时
	 * couType      可选   开课类型 代码类型11
	 * credit       可选   学分
	 * thrNO        可选   教师编号
	 * thrName      可选   教师姓名
	 * thrSex       可选   教师性别
	 * couNO        可选   课程编号
	 * couName      可选   课程名称
	 * claNO        可选   班级编号
	 * claName      可选   班级名称
	 * claGrade     可选   年级代码 代码类型(35)
	 * claMajor     可选   专业代码 代码类型(3)
	 * claCamId     可选   校区Id
	 * claDepId     可选   学部Id
	 * tccNO        可选   教学班编号
	 * tccName      可选   教学班名称
	 * tccGrade     可选   教学班年级 系统代码35
	 * tccMajor     可选   教学班专业 系统代码3
	 * tccCamId     可选   教学班校区Id
	 * tccDepId     可选   教学班学部Id
	 * romName      可选   场地名称
	 * romBuiId     可选   教学楼
	 * romBuiName   可选   教学楼名称
	 * scpDId       可选   排课细计划Id
	 * scmGrp       可选   方案分组
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_Schedule]}
	 *
	 */

	//==================================================================================================================
	// 查询 -- 周节课表（位课表转换为周节课表）
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询 -- 周节课表：没有分页，用于查询指定细计划，当前已排课程。
	 * 使用者：
	 *
	 * URL：schedule!queryWs.action
	 *
	 * 参数：参考query2。
	 * scpId    必需   排课计划Id
	 * scpDId   可选   排课细计划Id
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_Schedule]}
	 *
	 */

	//==================================================================================================================
	// 查询 -- 带冲突信息
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询 -- 带冲突信息
	 * 使用者：
	 *
	 * URL：schedule!queryRepeat.action
	 *
	 * 参数
	 * scpId     必需   排课计划Id
	 * thrId     可选   教师Id
	 * couId     可选   课程Id
	 * claId     可选   行政班Id
	 * tccId     可选   教学班Id
	 * romId     可选   场地Id
	 * thrName   可选   教师姓名
	 * couName   可选   课程名称
	 * claName   可选   班级名称(包括：行政班/教学班)
	 * romName   可选   场地名称
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_Schedule]}
	 *
	 * 注意：与符合条件的记录，有冲突的记录也会一起返回
	 *
	 */

	//==================================================================================================================
	// 获取所有课表
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：获取所有课表
	 * 使用者：
	 *
	 * URL：schedule!allAngleSched.action
	 *
	 * 参数
	 * scpId     必需   排课计划Id
	 * thrId     4选1   教师Id
	 * claId     4选1   行政班Id
	 * tccId     4选1   教学班Id
	 * romId     4选1   场地Id
	 * memSrc    可选   名单来源：1来自计划(默认)、2来自排课结果、3计划+排课结果
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_Schedule]}
	 *
	 * 注：这里也可以指定“4选1”参数获取单一课表，但性能上会不会后面的“oneAngleSched”接口
	 *
	 */

	//==================================================================================================================
	// 获取单张课表
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：获取单张课表
	 * 使用者：
	 *
	 * URL：schedule!oneAngleSched.action
	 *
	 * 参数
	 * scpId     必需   排课计划Id
	 * thrId     4选1   教师Id
	 * claId     4选1   行政班Id
	 * tccId     4选1   教学班Id
	 * romId     4选1   场地Id
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_Schedule]}
	 *
	 * 注意：与符合条件的记录，有冲突的记录也会一起返回
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：修改 -- 直接修改结果，不受计划方案影响（慎用）
	 * 使用者：
	 *
	 * URL：schedule!edit.action
	 *
	 * 参数
	 * schedId       必需   排课结果Id
	 * thrId         可选   教师Id
	 * couId         可选   课程Id
	 * claId         可选   行政班Id
	 * tccId         可选   教学班Id
	 * romId         可选   场地Id
	 * couType       可选   开课类型 代码类型11
	 * credit        可选   学分
     * bitStrWeekH   可选   位化开课周 -- 同组方案会连带一起变更
     * bitStrSched   可选   位化课表   -- 同组方案会连带一起变更
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：删除
	 * 使用者：
	 *
	 * URL：schedule!del.action
	 *
	 * 参数
	 * schedIds   必需   排课结果Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
