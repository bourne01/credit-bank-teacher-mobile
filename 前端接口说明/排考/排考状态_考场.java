/** 排考状态：考场 */

    /** 考试批次Id   */ private Integer   batId       ;
    /** 考场Id       */ private Integer   exmRomId    ;
    /** 考试时段Id   */ private Integer   timeId      ;
    /** 场地Id       */ private Integer   claRomId    ;
    /** 座位数量     */ private Short     seatNum     ;
    /** 并班系数     */ private Byte      merge       ; //1不允许并班(默认)，大于2为最多允许几个班，最大99
    /** 场地编号     */ private String    claRomNO    ;
    /** 场地名称     */ private String    claRomName  ;
    /** 教学楼       */ private Integer   buiId       ;
    /** 教学楼名称   */ private String    buiName     ;
    /** 排考Id       */ private Integer   arrId       ; //大于0为排考Id、-1不排考、-2有冲突、-3可排
    /** 时段名称     */ private String    timeName    ;
    /** 时段开始时间 */ private Timestamp startTime   ;
    /** 时段时长     */ private Integer   timeLong    ;
    /** 对应教学周次 */ private Byte      termWeek    ;
    /** 对应开始节次 */ private Byte      startSection;
    /** 对应结束节次 */ private Byte      endSection  ;
    /** 考试班Id     */ private String    exmClaId    ; //多个用“,”隔开
    /** 考试班名称   */ private String    exmClaName  ; //多个用“,”隔开
    /** 教学班Id     */ private String    claId       ; //多个用“,”隔开
    /** 考试班人数   */ private String    examStuNum  ; //多个用“,”隔开
    /** 考试班数量   */ private Long      exmClaNum   ;
    /** 考生总数     */ private Double    examStuTotal;

    /** 排序字段 */ private String[] orderFd ; //排序字段的名称，倒序前面加“@”，可以多个
    /** 排考状态 */ private Byte     arrState;
    /** 场地限制 */ private Byte     romLimit;

    //==================================================================================================================
    // 查询1 -- 考场的排考状态(已排时段+不可排时段)
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询1 -- 考场的排考状态(已排时段+不可排时段)
     * 使用者：教师
     *
     * URL：eaStateRom!query1.action
     *
     * 参数
     * start         可选   记录开始位置
     * limit         可选   获取记录数量
     * batId         可选   考试批次Id
     * exmRomId      可选   考场Id
     * termWeek      组01   对应教学周次
     * startSection  组01   对应开始节次
     * endSection    组01   对应结束节次
     * timeId        可选   考试时段Id
     * arrState      可选   1=包含其它有冲突的时段Id  只有指定了timeId时才有效
     * claRomId      可选   场地Id
     * seatNum       可选   座位数量
     * merge         可选   并班系数 1不允许并班(默认)，大于2为最多允许几个班，最大99
     * claRomNO      可选   场地编号
     * claRomName    可选   场地名称
     * buiId         可选   教学楼
     * buiName       可选   教学楼名称
     * arrId         可选   排考Id
     * timeName      可选   时段名称
     * timeLong      可选   时段时长
     * termWeek      可选   对应教学周次
     * startSection  可选   对应开始节次
     * endSection    可选   对应结束节次
     * exmClaId      可选   考试班Id 多个用“,”隔开
     * exmClaName    可选   考试班名称 多个用“,”隔开
     * claId         可选   教学班Id 多个用“,”隔开
     * examStuNum    可选   考试班人数 多个用“,”隔开
     * exmClaNum     可选   考试班数量
     * examStuTotal  可选   考生总数
     * orderFd       可选   排序字段的字段名称，倒序前面加“@”
     * 说明：“组01”的3个参数，必需同时指定，否由无效。当指定了“组01”的参数，则后面的timeId将被忽略
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Q_ExamArrRoom1]}
     *
     * 可用于：某考场(exmRomId)，查询某个时段(timeId)，是否已存在安排(arrState=1)
     * 可用于：某考场(exmRomId)，查询某个时段(组01)
     *
     */

    //==================================================================================================================
    // 查询2：时段-->考场信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2：时段-->考场信息
     * 使用者：教师
     *
     * URL：eaStateRom!queryRom.action
     *
     * 参数
     * timeId      必需   时段Id
     * arrState    可选   排考状态(基于时段的限制)：
     *                        0返回在指定时段已排考的考场(默认)
     *                        1返回在指定时段不能排考的考场(包含已排考)
     *                        2返回在指定时段可以排考的考场
     * romLimit    可选   场地限制(座位限制、并班限制)：
     *                        0不考虑制限(默认)、1(并)达到或超过限制、2(并)低于限制
     *                        11(或)达到或超过限制、12(或)低于限制
     * merge       可选   合并考场：0不合并(默认)、1合并 -- 因为允许同一时段同一考场重复排考，所以不合并就可能同一考场返回多条记录
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Q_ExamArrRoom2]}
     *
     * 可用于：查询指定时段(timeId)，有哪些考场可用(arrState=2)
     *
     */

    //==================================================================================================================
    // 查询3：考场-->时段信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询3：考场-->时段信息
     * 使用者：教师
     *
     * URL：eaStateRom!queryTime.action
     *
     * 参数
     * exmRomId   必需   考场Id
     * arrState   可选   排考状态：1已排、-1不可排、-2有冲突、-3可排；0查所有(默认)
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Q_ExamArrRoom3]}
     *
     * 可用于：查询监考员的时段安排信息
     *
     */

    //==================================================================================================================
