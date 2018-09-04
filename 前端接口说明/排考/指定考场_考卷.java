/** 指定考场 -- 考卷 */

    /** 考卷Id     */ private Integer paperId   ;
    /** 考场Id     */ private Integer exmRomId  ;
    /** 考试批次Id */ private Integer batId     ;
    /** 课程Id     */ private Integer couId     ;
    /** 考卷名称   */ private String  pprName   ;
    /** 考试方式   */ private Byte    examMode  ; // T_Code.F_Type=49 1闭卷(默认)、2开卷
    /** 试卷形式   */ private Byte    paperForm ; // T_Code.F_Type=50 1纸制(默认)、2电子、3第三方
    /** 承担单位   */ private Integer rshId     ;
    /** 考试时长   */ private Integer timeLong  ;
    /** 可分时段   */ private Byte    timeNum   ;
    /** 记录状态   */ private Byte    pprState  ; //2正常(默认)、3关闭、4历史
    /** 课程编号   */ private String  couNO     ;
    /** 课程名称   */ private String  couName   ;
    /** 场地Id     */ private Integer claRomId  ;
    /** 座位数量   */ private Short   seatNum   ;
    /** 并班系数   */ private Byte    merge     ; //1不允许并班(默认)，大于2为最多允许几个班，最大99
    /** 场地编号   */ private String  claRomNO  ;
    /** 场地名称   */ private String  claRomName;
    /** 教学楼     */ private Integer buiId     ;
    /** 教学楼名称 */ private String  buiName   ;

    /** 排序字段 */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个

    //==================================================================================================================
    // 查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询
     * 使用者：
     *
     * URL：pprExmRom!query.action
     *
     * 参数
     * start     可选   记录开始位置
     * limit     可选   获取记录数量
     * paperId   可选   考卷Id
     * exmRomId  可选   考场Id
     * orderFd   可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[ExamPprExamRoom]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细数据
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细数据
     * 使用者：教师
     *
     * URL：pprExmRom!query2.action
     *
     * 参数
     * start       可选   记录开始位置
     * limit       可选   获取记录数量
     * pprIds      可选   考卷Id(多个)
     * exmRomIds   可选   考场Id(多个)
     * batId       可选   考试批次Id
     * couId       可选   课程Id
     * pprName     可选   考卷名称
     * examMode    可选   考试方式  T_Code.F_Type=49 1闭卷(默认)、2开卷
     * paperForm   可选   试卷形式  T_Code.F_Type=50 1纸制(默认)、2电子、3第三方
     * rshId       可选   承担单位
     * timeLong    可选   考试时长
     * timeNum     可选   可分时段
     * pprState    可选   记录状态 2正常(默认)、3关闭、4历史
     * couNO       可选   课程编号
     * couName     可选   课程名称
     * claRomId    可选   场地Id
     * seatNum     可选   座位数量
     * merge       可选   并班系数 1不允许并班(默认)，大于2为最多允许几个班，最大99
     * claRomNO    可选   场地编号
     * claRomName  可选   场地名称
     * buiId       可选   教学楼
     * buiName     可选   教学楼名称
     * orderFd     可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_ExamPprExamRoom2]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：pprExmRom!newRec.action
     *
     * 参数
     * paperId   必需   考卷Id
     * exmRomId  必需   考场Id
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
     * URL：pprExmRom!del.action
     *
     * 参数
     * paperId   必需   考卷Id
     * exmRomId  必需   考场Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
