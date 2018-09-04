/** 排考状态：监考员 */

    /** 考试批次Id   */ private Integer   batId       ;
    /** 监考员Id     */ private Integer   prtId       ;
    /** 监考教师Id   */ private Integer   thrId       ;
    /** 教师编号     */ private String    thrNO       ;
    /** 教师姓名     */ private String    thrName     ;
    /** 教师性别     */ private String    thrSex      ;
    /** 监考下限     */ private Byte      timesLow    ;
    /** 监考上限     */ private Byte      timesMax    ;
    /** 已排场次     */ private Byte      times       ;
    /** 预设监考类型 */ private Byte      type        ;
    /** 排考Id       */ private Integer   arrId       ;
    /** 实际监考类型 */ private Byte      arrType     ; //1主监考、2副监考、3巡考、-1不排考、-2有冲突、-3可排
    /** 考试时段Id   */ private Integer   timeId      ;
    /** 时段名称     */ private String    timeName    ;
    /** 时段开始时间 */ private Timestamp startTime   ;
    /** 时段时长     */ private Integer   timeLong    ;
    /** 对应教学周次 */ private Byte      termWeek    ;
    /** 对应开始节次 */ private Byte      startSection;
    /** 对应结束节次 */ private Byte      endSection  ;
    /** 考场Id       */ private Integer   exmRomId    ;
    /** 场地Id       */ private Integer   claRomId    ;
    /** 场地编号     */ private String    claRomNO    ;
    /** 场地名称     */ private String    claRomName  ;
    /** 教学楼       */ private Integer   buiId       ;
    /** 教学楼名称   */ private String    buiName     ;

    /** 排序字段 */ private String[] orderFd   ; //排序字段的名称，倒序前面加“@”，可以多个
    /** 排考状态 */ private Byte     arrState  ;
    /** 场次限制 */ private Byte     timesLimit;
    /** 合并     */ private Byte     merge     ;

    //==================================================================================================================
    // 查询1 -- 监考员排考状态(已排时段+不可排时段)
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询1 -- 监考员排考状态(已排时段+不可排时段)
     * 使用者：教师
     *
     * URL：eaStatePro!query1.action
     *
     * 参数
     * start         可选   记录开始位置
     * limit         可选   获取记录数量
     * batId         可选   考试批次Id
     * prtId         可选   监考员Id
     * thrId         可选   监考教师Id
     * thrNO         可选   教师编号
     * thrName       可选   教师姓名
     * thrSex        可选   教师性别
     * timesLow      可选   监考下限
     * timesMax      可选   监考上限
     * times         可选   已排场次
     * type          可选   预设监考类型
     * arrId         可选   排考Id
     * arrType       可选   实际监考类型 1主监考、2副监考、3巡考、-1不排考
     * timeId        可选   考试时段Id
     * arrState      可选   1=包含其它有冲突的时段Id  只有指定了timeId时才有效
     * timeName      可选   时段名称
     * timeLong      可选   时段时长
     * termWeek      可选   对应教学周次
     * startSection  可选   对应开始节次
     * endSection    可选   对应结束节次
     * exmRomId      可选   考场Id
     * claRomId      可选   场地Id
     * claRomNO      可选   场地编号
     * claRomName    可选   场地名称
     * buiId         可选   教学楼
     * buiName       可选   教学楼名称
     * orderFd       可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Q_ExamArrProctor1]}
     *
     * 可用于：某监考员(prtId)，查询某个时段(timeId)，是否已存在安排(arrState=1)，
     *
     */

    //==================================================================================================================
    // 查询2：时段-->监考员信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2：时段-->监考员信息
     * 使用者：教师
     *
     * URL：eaStatePro!queryPro.action
     *
     * 参数
     * timeId      必需   时段Id
     * arrState    可选   排考状态(基于时段的限制)：
     *                        0返回在指定时段已排考的考场(默认)
     *                        1返回在指定时段不能排考的考场(包含已排考)
     *                        2返回在指定时段可以排考的考场
     * timesLimit  可选   场次限制：
     *                        0所有(默认)、1并达到或超过上限、2并低于上限、3并低于下限
     *                        11或达到或超过上限、12或低于上限、13或低于下限
     * merge       可选   合并教师：0不合并(默认)、1合并 -- 因为允许同一时段同一教师重复排考，所以不合并就可能同一教师返回多条记录
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Q_ExamArrProctor2]}
     *
     * 可用于：查询指定时段，有哪些监考员可用
     *
     */

    //==================================================================================================================
    // 查询3：监考员-->时段信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询3：监考员-->时段信息
     * 使用者：教师
     *
     * URL：eaStatePro!queryTime.action
     *
     * 参数
     * prtId      必需   监考员Id
     * arrState   可选   排考状态：1主监考、2副监考、3巡考、-1不可排、-2有冲突、-3可排；-4已排、0查所有(默认)
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Q_ExamArrProctor]}
     *
     * 可用于：查询监考员的时段安排信息
     *
     */

    //==================================================================================================================
