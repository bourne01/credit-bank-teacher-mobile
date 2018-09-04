/** 课表缓冲 */

	/** 课表缓冲Id   */ private Integer schBufId ;
	/** 排课计划Id   */ private Integer scpId    ;
	/** 课表类型     */ private Byte    type     ; //2来自任课表、3即时课表(默认)
	/** 教师任课Id   */ private Integer thrCouId ; //默认-1代表即时填写的课表
	/** 教师Id       */ private Integer thrId    ;
	/** 课程Id       */ private Integer couId    ;
	/** 行政班Id     */ private Integer claId    ;
	/** 教学班Id     */ private Integer tccId    ;
	/** 场地Id       */ private Integer romId    ;
	/** 开课周       */ private Integer weekHave ;
	/** 开课类型     */ private Integer couType  ; //代码类型11
	/** 学分         */ private Double  credit   ;
	/** 缓冲课时     */ private Byte    bufLesNum;
	/** 已排课时     */ private Byte    setLesNum;

	/** 教师编号     */ private String  thrNO    ;
	/** 教师姓名     */ private String  thrName  ;
	/** 教师性别     */ private String  thrSex   ;
	/** 课程编号     */ private String  couNO    ;
	/** 课程名称     */ private String  couName  ;
	/** 班级编号     */ private String  claNO    ;
	/** 班级名称     */ private String  claName  ;
	/** 年级代码     */ private Integer claGrade ; //代码类型(35)
	/** 专业代码     */ private Integer claMajor ; //代码类型(3)
	/** 校区Id       */ private Integer claCamId ;
	/** 学部Id       */ private Integer claDepId ;
	/** 教学班编号   */ private String  tccNO    ;
	/** 教学班名称   */ private String  tccName  ;
	/** 教学班年级   */ private Integer tccGrade ; //系统代码35
	/** 教学班专业   */ private Integer tccMajor ; //系统代码3
	/** 教学班校区Id */ private Integer tccCamId ;
	/** 教学班学部Id */ private Integer tccDepId ;
	/** 场地名称     */ private String  romName  ;

	/** 排序字段       */ private String[] orderFd    ; //排序字段的名称，倒序前面加“@”，可以多个
	/** 课表缓冲Id(组) */ private String   schBufIds  ; //多个用“,”隔开
    /** 位化开课周     */ private String   bitStrWeekH;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：
	 *
	 * URL：schBuff!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * schBufId     可选   课表缓冲Id
	 * scpId        可选   排课计划Id
	 * type         可选   课表类型 2来自任课表、3即时课表(默认)
	 * thrCouId     可选   教师任课Id 默认-1代表即时填写的课表
	 * thrId        可选   教师Id
	 * couId        可选   课程Id
	 * claId        可选   行政班Id
	 * tccId        可选   教学班Id
	 * romId        可选   场地Id
	 * weekHave     可选   开课周
	 * couType      可选   开课类型 代码类型11
	 * credit       可选   学分
	 * bufLesNum    可选   缓冲课时
	 * setLesNum    可选   已排课时
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[SchedBuff]}
	 *
	 */

	//==================================================================================================================
	// 查询2 -- 引入：成员名称
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询2 -- 引入：成员名称
	 * 使用者：
	 *
	 * URL：schBuff!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * schBufId     可选   课表缓冲Id
	 * scpId        可选   排课计划Id
	 * type         可选   课表类型 2来自任课表、3即时课表(默认)
	 * thrCouId     可选   教师任课Id 默认-1代表即时填写的课表
	 * thrId        可选   教师Id
	 * couId        可选   课程Id
	 * claId        可选   行政班Id
	 * tccId        可选   教学班Id
	 * romId        可选   场地Id
	 * weekHave     可选   开课周
	 * couType      可选   开课类型 代码类型11
	 * credit       可选   学分
	 * bufLesNum    可选   缓冲课时
	 * setLesNum    可选   已排课时
	 * thrNO        可选   教师编号
	 * thrName      可选   教师姓名
	 * thrSex       可选   教师性别
	 * couNO        可选   课程编号
	 * couName      可选   课程名称
	 * claNO        可选   班级编号
	 * claName      可选   班级名称 -- 没有指定tccName时，将同时查教学班名称
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
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_SchedBuff]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：新增
	 * 使用者：
	 *
	 * URL：schBuff!newRec.action
	 *
	 * 参数
	 * scpId         必需   排课计划Id
	 * type          可选   课表类型 2来自任课表、3即时课表(默认)
	 * thrCouId      可选   教师任课Id 默认-1代表即时填写的课表
	 * thrId         可选   教师Id
	 * couId         可选   课程Id
	 * claId         可选   行政班Id
	 * tccId         可选   教学班Id
	 * romId         可选   场地Id
	 * weekHave      可选   开课周
	 * couType       可选   开课类型 代码类型11
	 * credit        可选   学分
	 * bufLesNum     可选   缓冲课时
     * bitStrWeekH   可选   位化开课周
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功能信息","data":{SchedBuff}}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：修改
	 * 使用者：
	 *
	 * URL：schBuff!edit.action
	 *
	 * 参数
	 * schBufId      必需   课表缓冲Id
	 * type          可选   课表类型 2来自任课表、3即时课表(默认)
	 * thrCouId      可选   教师任课Id 默认-1代表即时填写的课表
	 * thrId         可选   教师Id
	 * couId         可选   课程Id
	 * claId         可选   行政班Id
	 * tccId         可选   教学班Id
	 * romId         可选   场地Id
	 * weekHave      可选   开课周
	 * couType       可选   开课类型 代码类型11
	 * credit        可选   学分
	 * bufLesNum     可选   缓冲课时
     * bitStrWeekH   可选   位化开课周
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
	 * URL：schBuff!del.action
	 *
	 * 参数
	 * schBufIds   必需   课表缓冲Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
