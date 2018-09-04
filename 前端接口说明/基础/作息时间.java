/** 作息时间 */

    /** 作息表Id        */ private Integer autoId         ;
    /** 作息表名称      */ private String  name           ;
    /** 早自习开始      */ private Time    mornSelfStart  ;
    /** 早自习结束      */ private Time    mornSelfEnd    ;
    /** 第1节开始       */ private Time    les1Start      ;
    /** 第1节结束       */ private Time    les1End        ;
    /** 第2节开始       */ private Time    les2Start      ;
    /** 第2节结束       */ private Time    les2End        ;
    /** 第3节开始       */ private Time    les3Start      ;
    /** 第3节结束       */ private Time    les3End        ;
    /** 第4节开始       */ private Time    les4Start      ;
    /** 第4节结束       */ private Time    les4End        ;
    /** 第5节开始       */ private Time    les5Start      ;
    /** 第5节结束       */ private Time    les5End        ;
    /** 第6节开始       */ private Time    les6Start      ;
    /** 第6节结束       */ private Time    les6End        ;
    /** 第7节开始       */ private Time    les7Start      ;
    /** 第7节结束       */ private Time    les7End        ;
    /** 第8节开始       */ private Time    les8Start      ;
    /** 第8节结束       */ private Time    les8End        ;
    /** 晚自习第1节开始 */ private Time    nightSelf1Start;
    /** 晚自习第1节结束 */ private Time    nightSelf1End  ;
    /** 晚自习第2节开始 */ private Time    nightSelf2Start;
    /** 晚自习第2节结束 */ private Time    nightSelf2End  ;
    /** 当前作息表      */ private Byte    cur            ; //1当前 2非当前(默认)
    /** 记录状态        */ private Byte    state          ; // 2正常(默认)、3关闭、4历史

    /** 排序字段 */ private String[] orderFd; //排序字段的名称，倒序前面加“@”，可以多个

    //==================================================================================================================
    // 查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询
     * 使用者：
     *
     * URL：public/timeTable!query.action
     *
     * 参数
     * start    可选   记录开始位置
     * limit    可选   获取记录数量
     * autoId   可选   作息表Id
     * name     可选   作息表名称
     * cur      可选   当前作息表 1当前 2非当前(默认)
     * state    可选   记录状态  2正常(默认)、3关闭、4历史
     * orderFd  可选   排序字段的字段名称，倒序前面加“@”
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[TimeTable]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：高级用户
     *
     * URL：public/timeTable!newRec.action
     *
     * 参数
     * name             必需   作息表名称
     * mornSelfStart    可选   早自习开始
     * mornSelfEnd      可选   早自习结束
     * les1Start        可选   第1节开始
     * les1End          可选   第1节结束
     * les2Start        可选   第2节开始
     * les2End          可选   第2节结束
     * les3Start        可选   第3节开始
     * les3End          可选   第3节结束
     * les4Start        可选   第4节开始
     * les4End          可选   第4节结束
     * les5Start        可选   第5节开始
     * les5End          可选   第5节结束
     * les6Start        可选   第6节开始
     * les6End          可选   第6节结束
     * les7Start        可选   第7节开始
     * les7End          可选   第7节结束
     * les8Start        可选   第8节开始
     * les8End          可选   第8节结束
     * nightSelf1Start  可选   晚自习第1节开始
     * nightSelf1End    可选   晚自习第1节结束
     * nightSelf2Start  可选   晚自习第2节开始
     * nightSelf2End    可选   晚自习第2节结束
     * cur              可选   当前作息表 1当前 2非当前(默认)
     * state            可选   记录状态  2正常(默认)、3关闭、4历史
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"data":{TimeTable}}
     *
     */

    //==================================================================================================================
    // 修改
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：修改
     * 使用者：高级用户
     *
     * URL：public/timeTable!edit.action
     *
     * 参数
     * autoId           必需   作息表Id
     * name             可选   作息表名称
     * mornSelfStart    可选   早自习开始
     * mornSelfEnd      可选   早自习结束
     * les1Start        可选   第1节开始
     * les1End          可选   第1节结束
     * les2Start        可选   第2节开始
     * les2End          可选   第2节结束
     * les3Start        可选   第3节开始
     * les3End          可选   第3节结束
     * les4Start        可选   第4节开始
     * les4End          可选   第4节结束
     * les5Start        可选   第5节开始
     * les5End          可选   第5节结束
     * les6Start        可选   第6节开始
     * les6End          可选   第6节结束
     * les7Start        可选   第7节开始
     * les7End          可选   第7节结束
     * les8Start        可选   第8节开始
     * les8End          可选   第8节结束
     * nightSelf1Start  可选   晚自习第1节开始
     * nightSelf1End    可选   晚自习第1节结束
     * nightSelf2Start  可选   晚自习第2节开始
     * nightSelf2End    可选   晚自习第2节结束
     * cur              可选   当前作息表 1当前 2非当前(默认)
     * state            可选   记录状态  2正常(默认)、3关闭、4历史
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
     * 使用者：高级用户
     *
     * URL：public/timeTable!chState.action
     *
     * 参数：
     * autoId   必需   作息表Id
     * state    必需   新状态
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"状态修改成功！"}
     *
     */

    //==================================================================================================================
    // 删除
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：删除
     * 使用者：高级用户
     *
     * URL：public/timeTable!del.action
     *
     * 参数
     * autoId   必需   作息表Id
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"message":"成功信息"}
     *
     */

    //==================================================================================================================
