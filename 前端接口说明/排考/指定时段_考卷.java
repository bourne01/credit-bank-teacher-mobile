/** 指定时段_考卷 */

    /** 考卷Id       */ private Integer   paperId     ;
    /** 考试时段Id   */ private Integer   timeId      ;
    /** 考试批次Id   */ private Integer   batId       ;
    /** 课程Id       */ private Integer   couId       ;
    /** 考卷名称     */ private String    pprName     ;
    /** 考卷文件名   */ private String    fileName    ;
    /** 考试方式     */ private Byte      examMode    ; // T_Code.F_Type=49 1闭卷(默认)、2开卷
    /** 试卷形式     */ private Byte      paperForm   ; // T_Code.F_Type=50 1纸制(默认)、2电子、3第三方
    /** 承担单位     */ private Integer   rshId       ;
    /** 试卷考试时长 */ private Integer   pprTimeLong ;
    /** 可分时段     */ private Byte      timeNum     ;
    /** 时段名称     */ private String    timeName    ;
    /** 时段开始时间 */ private Timestamp startTime   ;
    /** 时段时长     */ private Integer   timeLong    ;
    /** 对应教学周次 */ private Byte      termWeek    ;
    /** 对应开始节次 */ private Byte      startSection;
    /** 对应结束节次 */ private Byte      endSection  ;

    /** 排序字段 */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个

    //==================================================================================================================
    // 查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询
     * 使用者：
     *
     * URL：pprTime!query.action
     *
     * 参数
     * start    可选   记录开始位置
     * limit    可选   获取记录数量
     * paperId  可选   考卷Id
     * timeId   可选   考试时段Id
     * orderFd  可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[PaperTime]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细信息
     * 使用者：教师
     *
     * URL：pprTime!query2.action
     *
     * 参数
     * start         可选   记录开始位置
     * limit         可选   获取记录数量
     * pprIds        可选   考卷Id(多个)
     * timeIds       可选   考试时段Id(多个)
     * batId         可选   考试批次Id
     * couId         可选   课程Id
     * pprName       可选   考卷名称
     * fileName      可选   考卷文件名
     * examMode      可选   考试方式  T_Code.F_Type=49 1闭卷(默认)、2开卷
     * paperForm     可选   试卷形式  T_Code.F_Type=50 1纸制(默认)、2电子、3第三方
     * rshId         可选   承担单位
     * pprTimeLong   可选   试卷考试时长
     * timeNum       可选   可分时段
     * timeName      可选   时段名称
     * timeLong      可选   时段时长
     * termWeek      可选   对应教学周次
     * startSection  可选   对应开始节次
     * endSection    可选   对应结束节次
     * orderFd       可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_PaperTime]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：pprTime!newRec.action
     *
     * 参数
     * paperId  必需   考卷Id
     * timeId   必需   考试时段Id
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
     * URL：pprTime!del.action
     *
     * 参数
     * paperId  必需   考卷Id
     * timeId   必需   考试时段Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
