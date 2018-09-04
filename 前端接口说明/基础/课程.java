/** 课程 */

    /** 自增流水号 */ private Integer autoId      ;
    /** 课程编号   */ private String  nO          ;
    /** 课程名称   */ private String  name        ;
    /** 适用科目   */ private Integer subject     ;
    /** 适用专业   */ private Integer applySpe    ;
    /** 适用年级   */ private Integer applyGrade  ;
    /** 授课场所   */ private String  teachPlace  ;
    /** 授课方式   */ private Integer teachMode   ;
    /** 总课时     */ private Short   lesNum      ;
    /** 周课时     */ private Byte    weekLesNum  ;
    /** 课程学分   */ private Double  resultCredit;
    /** 课时权重   */ private Double  lesPower    ;
    /** 教研组Id   */ private Integer rshId       ;
    /** 状态       */ private Byte    state       ; //1草稿、2正常(默认)、3关闭、4历史

    /** 按编号排序 */ private Byte   orderO ;
    /** 按名称排序 */ private Byte   orderN ;
    /** 课程Id(组) */ private String autoIds; //多个用“,”隔开

    //==================================================================================================================
    //查询
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询
     * 使用者：无限制
     *
     * URL：public/cou!query.action
     *
     * 参数：
     * start     可选   记录开始位置
     * limit     可选   获取记录数量
     * autoId    可选   记录Id
     * nO        可选   编号(模糊匹配)
     * name      可选   名称(模糊匹配)
     * state     可选   记录状态：2正常、3关闭、4历史
     * orderO    可选   按编号排序：1从小到大、2从大到小
     * orderN    可选   按名称排序：1从小到大、2从大到小
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Course]}
     *
     */

    //==================================================================================================================
    // 新增
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：教师
     *
     * URL：public/cou!newRec.action
     *
     * 参数
     * nO            必需   课程编号
     * name          必需   课程名称
     * subject       可选   适用科目
     * applySpe      可选   适用专业
     * applyGrade    可选   适用年级
     * teachPlace    可选   授课场所
     * teachMode     可选   授课方式
     * lesNum        可选   总课时
     * weekLesNum    可选   周课时
     * resultCredit  可选   课程学分
     * lesPower      可选   课时权重
     * rshId         可选   教研组Id
     * state         可选   课程状态  1草稿、2正常(默认)、3关闭、4历史
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"data":{Course}}
     *
     */

    //==================================================================================================================
    // 修改
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：新增
     * 使用者：教师
     *
     * URL：public/cou!edit.action
     *
     * 参数
     * autoId        必需   课程Id
     * nO            可选   课程编号
     * name          可选   课程名称
     * subject       可选   适用科目
     * applySpe      可选   适用专业
     * applyGrade    可选   适用年级
     * teachPlace    可选   授课场所
     * teachMode     可选   授课方式
     * lesNum        可选   总课时
     * weekLesNum    可选   周课时
     * resultCredit  可选   课程学分
     * lesPower      可选   课时权重
     * rshId         可选   教研组Id
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
	 * URL：public/cou!chState.action
	 *
	 * 参数
	 * autoIds   必需   课程Id 多个用“,”隔开
	 * state    必需   状态值
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
	 * URL：public/cou!del.action
	 *
	 * 参数
	 * autoIds   必需   课程Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

    //==================================================================================================================
