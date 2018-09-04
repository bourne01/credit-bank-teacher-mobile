/** 教师课时 */

	/** 排课计划Id   */ private Integer scpId              ;
	/** 教师Id       */ private Integer thrId              ;
	/** 初始课表     */ private Long    iniSched           ;
	/** 排课学期Id   */ private Integer termId             ;
	/** 教师编号     */ private String  thrNO              ;
	/** 教师姓名     */ private String  thrName            ;
	/** 教师性别     */ private String  thrSex             ;
	/** 学部Id       */ private Integer thrDepId           ;
	/** 教研组Id     */ private Integer thrRshId           ;
	/** 排课计划名称 */ private String  scpName            ;
	/** 标准周课时   */ private Short   staWeekLesNum      ;
	/** 排课周 　    */ private String  weekHave           ;
	/** 累计已排     */ private Double  totalSetLesNum     ;  //所有排课结果的课时
	/** 累计加权     */ private Double  totalSetLesNumPower;  //所有排课结果的课时加权
	/** 计划课时     */ private Double  scmLesNum          ;  //排课方案中计划课时
	/** 计划已排     */ private Double  scmSetLesNum       ;  //排课方案中计划课时已排

	/** 排序字段 */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个

	//==================================================================================================================
	// 教师课时报表 -- 查询
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：教师课时报表 -- 查询
	 * 使用者：
	 *
	 * URL：schThrLesNum!query.action
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
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_SchThrPlan]}
	 *
	 */

	//==================================================================================================================
	// 教师课时报表 -- 导出
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：教师课时报表 -- 导出
	 * 使用者：
	 *
	 * URL：schThrLesNum!export.action
     *
     * 参数：参考上面query接口
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     *
     */

    //==================================================================================================================
