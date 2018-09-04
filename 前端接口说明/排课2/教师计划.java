/** 教师计划 */

	/** 排课计划Id   */ private Integer scpId        ;
	/** 教师Id       */ private Integer thrId        ;
	/** 初始课表     */ private Long    iniSched     ;
	/** 排课学期Id   */ private Integer termId       ;
	/** 教师编号     */ private String  thrNO        ;
	/** 教师姓名     */ private String  thrName      ;
	/** 教师性别     */ private String  thrSex       ;
	/** 学部Id       */ private Integer thrDepId     ;
	/** 教研组Id     */ private Integer thrRshId     ;
	/** 排课计划名称 */ private String  scpName      ;
	/** 标准周课时   */ private Short   staWeekLesNum;

	/** 排序字段   */ private String[] orderFd    ; //排序字段的名称，倒序前面加“@”，可以多个
	/** 教师Id(组) */ private String   thrIds     ; //多个用“,”隔开
    /** 位化课表   */ private String   bitStrSched;
    /** 返回周课表 */ private Byte     rtnCurSched;

	//==================================================================================================================
	// 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询
	 * 使用者：+ 部门负责人(自己负责的部门)
	 *
	 * URL：schThrPlan!query.action
	 *
	 * 参数
	 * start          可选   记录开始位置
	 * limit          可选   获取记录数量
	 * scpId          必需   排课计划Id
	 * thrId          可选   教师Id
	 * termId         可选   排课学期Id
	 * thrNO          可选   教师编号
	 * thrName        可选   教师姓名
	 * thrSex         可选   教师性别
	 * thrDepId       可选   学部Id
	 * thrRshId       可选   教研组Id
	 * scpName        可选   排课计划名称
	 * staWeekLesNum  可选   标准周课时
	 * orderFd        可选   排序字段的字段名称，倒序前面加“@”
	 * rtnCurSched    可选   1=返回当前课表（还必需指定scpId参数），默认不返回
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_SchThrPlan]}
	 *
	 */

	//==================================================================================================================
	// 保存
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：保存
	 * 使用者：+ 部门负责人
	 *
	 * URL：schThrPlan!saveRec.action
	 *
	 * 参数
	 * scpId        必需   排课计划Id
	 * thrId        必需   教师Id
	 * bitStrSched  必需   初始课表
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功能信息"}
	 *
	 */

	//==================================================================================================================
	// 删除
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：删除
	 * 使用者：
	 *
	 * URL：schThrPlan!del.action
	 *
	 * 参数
	 * scpId    必需   排课计划Id
	 * thrIds   必需   教师Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

	//==================================================================================================================
