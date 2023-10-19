package io.renren.modules.gptKey.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * KEY管理
 *
 * @author Mr.star 26011687@qq.com
 * @since 1.0.0 2023-04-12
 */
@Data
public class GptKeyExcel {
    @Excel(name = "ID")
    private Long id;
    @Excel(name = "GPT的KEY")
    private String key;
    @Excel(name = "状态(0启用1关闭)")
    private Integer status;
    @Excel(name = "备注")
    private String remark;


}