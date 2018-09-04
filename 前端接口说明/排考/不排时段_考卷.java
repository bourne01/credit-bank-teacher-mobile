/** 考卷不排考时段 */

    /** 考卷Id       */ private Integer   paperId     ;
    /** 考试时段Id   */ private Integer   timeId      ;
    /** 考试批次Id   */ private Integer   batId       ;
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
     * URL：pprTimeEx!query.action
     *
     * 参数
     * start    可选   记录开始位置
     * limit    可选   获取记录数量
     * paperId  可选   考卷Id
     * timeId   可选   考试时段Id
     * orderFd  可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[PaperTimeExcept]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细信息
     * 使用者：教师
     *
     * URL：pprTimeEx!query2.action
     *
     * 参数
     * start         可选   记录开始位置
     * limit         可选   获取记录数量
     * paperId       可选   考卷Id
     * timeId        可选   考试时段Id
     * batId         可选   考试批次Id
     * timeName      可选   时段名称
     * timeLong      可选   时段时长
     * termWeek      可选   对应教学周次
     * startSection  可选   对应开始节次
     * endSection    可选   对应结束节次
     * orderFd       可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_PaperTimeExcept]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：pprTimeEx!newRec.action
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
     * 使用者：
     *
     * URL：pprTimeEx!del.action
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
