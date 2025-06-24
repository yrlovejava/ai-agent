package com.xiaobai.aiagent.tools;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import com.xiaobai.aiagent.constant.FileConstant;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.io.File;

/**
 * 资源下载工具
 */
public class ResourceDownloadTool {

    @Tool(description = "Downloads a resource from a given URL and saves it to a file")
    public String downloadResource(
            @ToolParam(description = "URL of the resource to download")String url,
            @ToolParam(description = "Name of the file to save the downloaded resource")String fileName) {
        String fileDir = FileConstant.FILE_SAVE_DIR + "/download";
        String filePath = fileDir + "/" + fileName;
        try {
            if(!FileUtil.exist(fileDir)){
                FileUtil.mkdir(fileDir);
            }
            HttpUtil.downloadFile(url,new File(filePath));
            return "Resource downloaded successfully to: " + filePath;
        }catch (Exception ex){
            return "Failed to download resource: " + ex.getMessage();
        }
    }
}
