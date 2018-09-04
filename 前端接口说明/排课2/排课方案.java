/** 排课方案 */

	/** 排课方案Id     */ private Integer scpSId        ;
	/** 排课计划明细Id */ private Integer scpDId        ;
	/** 方案分组       */ private Byte    scmGrp        ;
	/** 教师Id         */ private Integer thrId         ;
	/** 课程Id         */ private Integer couId         ;
	/** 行政班Id       */ private Integer claId         ;
	/** 教学班Id       */ private Integer tccId         ;
	/** 场地Id         */ private Integer romId         ; //默认-1代表场地未确认
	/** 方案课时       */ private Byte    scmLesNum     ;
	/** 已排课时       */ private Byte    setLesNum     ;
	/** 学分           */ private Double  credit        ;
	/** 备注           */ private String  remark        ;
	/** 方案状态       */ private Byte    scpSState     ; //2正常(默认) 3关闭 4完成
	/** 排课计划Id     */ private Integer scpId         ;
	/** 归属部门Id     */ private Integer depId         ; //默认-1表示无归属部门
	/** 归属教研组     */ private Integer rshId         ; //默认-1表示无归属教研组
	/** 周课时         */ private Byte    weekLesNum    ;
	/** 方案课时(总)   */ private Byte    scmLesNumTotal;
	/** 已排课时(总)   */ private Byte    setLesNumTotal;
	/** 连课数         */ private Byte    dayLesNum     ;
	/** 教师编号       */ private String  thrNO         ;
	/** 教师姓名       */ private String  thrName       ;
	/** 教师性别       */ private String  thrSex        ;
	/** 课程编号       */ private String  couNO         ;
	/** 课程名称       */ private String  couName       ;
	/** 班级编号       */ private String  claNO         ;
	/** 班级名称       */ private String  claName       ;
	/** 年级代码       */ private Integer claGrade      ; //代码类型(35)
	/** 专业代码       */ private Integer claMajor      ; //代码类型(3)
	/** 校区Id         */ private Integer claCamId      ;
	/** 学部Id         */ private Integer claDepId      ;
	/** 教学班编号     */ private String  tccNO         ;
	/** 教学班名称     */ private String  tccName       ;
	/** 教学班年级     */ private Integer tccGrade      ; //系统代码35
	/** 教学班专业     */ private Integer tccMajor      ; //系统代码3
	/** 教学班校区Id   */ private Integer tccCamId      ;
	/** 教学班学部Id   */ private Integer tccDepId      ;
	/** 场地名称       */ private String  romName       ;

	/** 排序字段         */ private String[] orderFd    ; //排序字段的名称，倒序前面加“@”，可以多个
	/** 排课方案Id(组)   */ private String   scpSIds    ; //多个用“,”隔开
	/** 完成状态(方案)   */ private Byte     finishScm  ;
	/** 完成状态(细计划) */ private Byte     finishPlanD;
	/** 类型参数         */ private Byte     type       ;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：
	 *
	 * URL：schScheme!query.action
	 *
	 * 参数
	 * start        可选   记录开始位置
	 * limit        可选   获取记录数量
	 * scpSId       可选   排课方案Id
	 * scpDId       可选   排课计划明细Id
	 * scmGrp       可选   方案分组
	 * thrId        可选   教师Id
	 * couId        可选   课程Id
	 * claId        可选   行政班Id
	 * tccId        可选   教学班Id
	 * romId        可选   场地Id 默认-1代表场地未确认
	 * credit       可选   学分
	 * remark       可选   备注
	 * scpSState    可选   方案状态 2正常(默认) 3关闭 4完成
	 * finishScm    可选   方案课时是否已排完：0(默认)=无限制、1=未排完、2=已排完
	 * orderFd      可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[SchedScheme]}
	 *
	 */

	//==================================================================================================================
	// 查询2 -- 引入：细计划信息 + 成员名称
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询2 -- 引入：细计划信息 + 成员名称
	 * 使用者：
	 *
	 * URL：schScheme!query2.action
	 *
	 * 参数
	 * start           可选   记录开始位置
	 * limit           可选   获取记录数量
	 * scpSId          可选   排课方案Id
	 * scpDId          可选   排课计划明细Id
	 * scmGrp          可选   方案分组
	 * thrId           可选   教师Id
	 * couId           可选   课程Id
	 * claId           可选   行政班Id 负数代表教学班Id
	 * tccId           可选   教学班Id
	 * romId           可选   场地Id 默认-1代表场地未确认
	 * credit          可选   学分
	 * remark          可选   备注
	 * scpSState       可选   方案状态 2正常(默认) 3关闭 4完成
	 * finishScm       可选   方案课时是否已排完：0(默认)=无限制、1=未排完、2=已排完
	 * finishPlanD     可选   细计划课时是否已排完：0(默认)=无限制、1=未排完、2=已排完
	 * scpId           可选   排课计划Id
	 * depId           可选   归属部门Id 默认-1表示无归属部门
	 * rshId           可选   归属教研组 默认-1表示无归属教研组
	 * weekLesNum      可选   周课时
	 * dayLesNum       可选   连课数
	 * thrNO           可选   教师编号
	 * thrName         可选   教师姓名
	 * thrSex          可选   教师性别
	 * couNO           可选   课程编号
	 * couName         可选   课程名称
	 * claNO           可选   班级编号
	 * claName         可选   班级名称
	 * claGrade        可选   年级代码 代码类型(35)
	 * claMajor        可选   专业代码 代码类型(3)
	 * claCamId        可选   校区Id
	 * claDepId        可选   学部Id
	 * tccNO           可选   教学班编号
	 * tccName         可选   教学班名称
	 * tccGrade        可选   教学班年级 系统代码35
	 * tccMajor        可选   教学班专业 系统代码3
	 * tccCamId        可选   教学班校区Id
	 * tccDepId        可选   教学班学部Id
	 * romName         可选   场地名称
	 * orderFd         可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_SchedScheme]}
	 *
	 */

	//==================================================================================================================
	// 新增
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：新增
	 * 使用者：
	 *
	 * URL：schScheme!newRec.action
	 *
	 * 参数
	 * scpDId     必需   排课计划明细Id
	 * scmGrp     可选   方案分组 默认0
	 * thrId      必需   教师Id
	 * couId      必需   课程Id
	 * claId      2选1   行政班Id
	 * tccId      2选1   教学班Id
	 * romId      可选   场地Id 默认-1代表场地未确认
	 * scmLesNum  可选   方案课时
	 * credit     可选   学分
	 * remark     可选   备注
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功能信息","data":{SchedScheme}}
	 *
	 */

	//==================================================================================================================
	// 修改
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：修改
	 * 使用者：
	 *
	 * URL：schScheme!edit.action
	 *
	 * 参数
	 * scpSId     必需   排课方案Id
	 * scmGrp     可选   方案分组
	 * thrId      可选   教师Id
	 * couId      可选   课程Id
	 * claId      可选   行政班Id
	 * tccId      可选   教学班Id
	 * romId      可选   场地Id 默认-1代表场地未确认
	 * scmLesNum  可选   方案课时
	 * credit     可选   学分
	 * remark     可选   备注
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
	// 修改记录状态
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：修改记录状态
	 * 使用者：
	 *
	 * URL：schScheme!chState.action
	 *
	 * 参数
	 * scpSIds    必需   排课方案Id 多个用“,”隔开
	 * scpSState  必需   状态值
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
	 * URL：schScheme!del.action
	 *
	 * 参数
	 * scpSIds   必需   排课方案Id 多个用“,”隔开
	 * type      可选   1=直接删除不管状态
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
