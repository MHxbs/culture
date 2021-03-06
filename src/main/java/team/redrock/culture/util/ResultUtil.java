package team.redrock.culture.util;


import team.redrock.culture.domain.Result;
import team.redrock.culture.domain.ResultEnum;

public class ResultUtil {

    public static Result success(Object data){
        Result result=new Result();
        result.setMsg("OK");
        result.setStatus(200);
        result.setData(data);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(ResultEnum resultEnum){
        Result result=new Result();
        result.setMsg(resultEnum.getMsg());
        result.setStatus(resultEnum.getStatus());

        return  result;
    }

   /* public static Result error(String msg){
        Result result=new Result();
        result.setMsg(msg);
        result.setStatus(400);

        return  result;
    }*/

}
