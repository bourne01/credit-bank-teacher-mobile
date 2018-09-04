/** 考试安排(排考结果) */

	/** 排考Id       */ private Integer   autoId      ;
	/** 考试批次Id   */ private Integer   batId       ;
	/** 考试时段Id   */ private Integer   timeId      ;
	/** 考场Id       */ private Integer   exmRomId    ;
	/** 考试计划Id   */ private Integer   planId      ;
	/** 考试类型     */ private Integer   examType    ; //T_Code.F_Type=48 1期中考试、2期末考试、3月考、4会考、5高考
	/** 批次名称     */ private String    batName     ;
	/** 时段名称     */ private String    timeName    ;
	/** 时段开始时间 */ private Timestamp startTime   ;
	/** 时段时长     */ private Integer   timeLong    ;
	/** 对应教学周次 */ private Byte      termWeek    ;
	/** 对应开始节次 */ private Byte      startSection;
	/** 对应结束节次 */ private Byte      endSection  ;
	/** 座位数量     */ private Short     seatNum     ;
	/** 并班系数     */ private Byte      merge       ;
	/** 场地Id       */ private Integer   claRomId    ;
	/** 场地编号     */ private String    claRomNO    ;
	/** 场地名称     */ private String    claRomName  ;
	/** 教学楼       */ private Integer   buiId       ;
	/** 教学楼名称   */ private String    buiName     ;
	/** 监考员Id     */ private Integer   prtId       ;
	/** 设置监考类型 */ private Byte      prtType     ; //T_Code.F_Type=51 1主监考、2副监考、3巡考
	/** 教师Id       */ private Integer   thrId       ;
	/** 教师编号     */ private String    thrNO       ;
	/** 教师姓名     */ private String    thrName     ;
	/** 教师性别     */ private String    thrSex      ;
	/** 监考下限     */ private Byte      prtTimesLow ;
	/** 监考上限     */ private Byte      prtTimesMax ;
	/** 已排场次     */ private Byte      prtTimes    ;
	/** 实际监考类型 */ private Byte      prtArrType  ; //T_Code.F_Type=51 1主监考、2副监考、3巡考
	/** 考试班Id     */ private Integer   exmClaId    ;
	/** 考试班名称   */ private String    exmClaName  ;
	/** 教学班Id     */ private Integer   claId       ;
	/** 考生人数     */ private Short     examStuNum  ;
    /** 考试班数量   */ private Integer   exmClaNum   ;
    /** 考生总数     */ private Integer   examStuTotal;
    
    /** 排序字段     */ private String[] orderFd  ; //排序字段的名称，倒序前面加“@”，可以多个
    /** 排考Id(多个) */ private String   autoIds  ; //用“,”隔开的多个排考Id
    /** 排考Id(1)    */ private Integer  autoId1  ;
    /** 排考Id(2)    */ private Integer  autoId2  ;
    
    //==================================================================================================================
    // 查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询
     * 使用者：
     *
     * URL：examArr!query.action
     *
     * 参数
     * start     可选   记录开始位置
     * limit     可选   获取记录数量
     * autoIds   可选   排考Id(多个用“,”隔开)
     * batId     可选   考试批次Id
     * timeId    可选   考试时段Id
     * exmRomId  可选   考场Id
     * orderFd   可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[ExamArrange]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细信息
     * 使用者：教师
     *
     * URL：examArr!query2.action
     *
     * 参数
     * start       可选   记录开始位置
     * limit       可选   获取记录数量
     * autoIds     可选   排考Id(多个用“,”隔开)
     * batId       可选   考试批次Id
     * timeId      可选   考试时段Id
     * exmRomId    可选   考场Id
     * planId      可选   考试计划Id
     * examType    可选   考试类型 T_Code.F_Type=48 1期中考试、2期末考试、3月考、4会考、5高考
     * batName     可选   批次名称
     * timeName    可选   时段名称
     * claRomId    可选   场地Id
     * claRomName  可选   场地名称
     * orderFd     可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ExamArrange]}
     *
     */

	//==================================================================================================================
	// 查询3 --- 更详细的内容
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：查询3 --- 更详细的内容
	 * 使用者：教师
	 *
	 * URL：examArr!query3.action
	 *
	 * 参数
	 * start         可选   记录开始位置
	 * limit         可选   获取记录数量
     * autoIds       可选   排考Id(多个用“,”隔开)
	 * batId         可选   考试批次Id
	 * timeId        可选   考试时段Id
	 * exmRomId      可选   考场Id
	 * planId        可选   考试计划Id
	 * examType      可选   考试类型 T_Code.F_Type=48 1期中考试、2期末考试、3月考、4会考、5高考
	 * batName       可选   批次名称
	 * timeName      可选   时段名称
	 * timeLong      可选   时段时长
	 * termWeek      可选   对应教学周次
	 * startSection  可选   对应开始节次
	 * endSection    可选   对应结束节次
	 * seatNum       可选   座位数量
	 * merge         可选   并班系数
	 * claRomId      可选   场地Id
	 * claRomNO      可选   场地编号
	 * claRomName    可选   场地名称
	 * buiId         可选   教学楼
	 * buiName       可选   教学楼名称
	 * prtId         可选   监考员Id
	 * prtType       可选   设置监考类型
	 * thrId         可选   教师Id
	 * thrNO         可选   教师编号
	 * thrName       可选   教师姓名
	 * thrSex        可选   教师性别
	 * prtTimesLow   可选   监考下限
	 * prtTimesMax   可选   监考上限
	 * prtTimes      可选   已排场次
	 * prtArrType    可选   实际监考类型
	 * exmClaId      可选   考试班Id
	 * exmClaName    可选   考试班名称
	 * claId         可选   教学班Id
	 * examStuNum    可选   考生人数
	 * orderFd       可选   排序字段的字段名称，倒序前面加“@”
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ExamArrange4]}
	 *
	 */
	
    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：examArr!newRec.action
     *
     * 参数
     * batId     必需   考试批次Id
     * timeId    可选   考试时段Id
     * exmRomId  可选   考场Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"data":{ExamArrange}}
     *
     */

    //==================================================================================================================
    // 修改
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：修改
     * 使用者：高级用户
     *
     * URL：examArr!edit.action
     *
     * 参数
     * autoId    必需   排考Id
     * batId     可选   考试批次Id
     * timeId    可选   考试时段Id
     * exmRomId  可选   考场Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
    // 交换考场
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：交换考场
     * 使用者：高级用户
     *
     * URL：examArr!swapRom.action
     *
     * 参数
     * autoId1    必需   排考Id(1)
     * autoId2    必需   排考Id(2)
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
     * 使用者：高级用户
     *
     * URL：examArr!del.action
     *
     * 参数
     * autoId  必需   排考Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
