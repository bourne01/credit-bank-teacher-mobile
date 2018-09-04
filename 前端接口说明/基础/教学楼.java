/** 教学楼 */

    /** 教学楼Id */ private Integer autoId ;
    /** 编号     */ private String  nO     ;
    /** 名称     */ private String  name   ;
    /** 校区Id   */ private Integer camId  ;
    /** 部门Id   */ private Integer depId  ;
    /** 状态     */ private Byte    state  ; //2正常(默认)、3关闭、4历史
    /** 校区名称 */ private String  camName;
    /** 部门名称 */ private String  depName;

    /** 按编号排序   */ private Byte   orderO;
    /** 按名称排序   */ private Byte   orderN;
	/** 教学楼Id(组) */ private String autoIds; //多个用“,”隔开

    //==================================================================================================================
    // 查询 -- 基本信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询 -- 基本信息
     * 使用者：无限制
     *
     * URL：public/build!query.action
     *
     * 参数：
     * start      可选   记录开始位置
     * limit      可选   获取记录数量
     * autoId     可选   教学楼Id
     * nO         可选   编号(模糊匹配)
     * name       可选   名称(模糊匹配)
     * camId      可选   校区Id
     * depId      可选   部门Id
     * state      可选   记录状态：2正常、3关闭、4历史
     * orderO     可选   按编号排序：1从小到大、2从大到小
     * orderN     可选   按名称排序：1从小到大、2从大到小
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[Building]}
     *
     */

    //==================================================================================================================
    // 查询2 -- 详细信息
    //------------------------------------------------------------------------------------------------------------------
    /**<pre>
     *   功能：查询2 -- 详细信息
     * 使用者：无限制
     *
     * URL：public/build!query2.action
     *
     * 参数：
     * start      可选   记录开始位置
     * limit      可选   获取记录数量
     * autoId     可选   教学楼Id
     * nO         可选   编号(模糊匹配)
     * name       可选   名称(模糊匹配)
     * camId      可选   校区Id
     * depId      可选   部门Id
     * state      可选   记录状态：2正常、3关闭、4历史
     * camName    可选   校区名称(模糊匹配)
     * depName    可选   部门名称(模糊匹配)
     * orderO     可选   按编号排序：1从小到大、2从大到小
     * orderN     可选   按名称排序：1从小到大、2从大到小
     *
     * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
     * 正确返回：{"success":true,"total":"总记录数","dataList":[V_Building]}
     *
     */

	//==================================================================================================================
	// 修改记录状态
	//------------------------------------------------------------------------------------------------------------------
	/**<pre>
	 *   功能：修改记录状态
	 * 使用者：
	 *
	 * URL：public/build!chState.action
	 *
	 * 参数
	 * autoIds   必需   教学楼Id 多个用“,”隔开
	 * state     必需   状态值
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
	 * URL：public/build!del.action
	 *
	 * 参数
	 * autoIds   必需   教学楼Id 多个用“,”隔开
	 *
	 * 出错返回：{"success":false,"type":1或2,"message":"错误信息"} 1已知错误、2未知错误
	 * 正确返回：{"success":true,"message":"成功信息"}
	 *
	 */

    //==================================================================================================================
