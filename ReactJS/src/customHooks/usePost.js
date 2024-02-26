import axios from "axios";
import { useCallback, useState } from "react";

export default function usePost()
{
    const [data,setData]=useState([]);

    const postData=useCallback((url,newData)=>{

        axios.post(url,newData)
        .then(res=>setData(res.data));
            
    },[]);

    return {data,postData};
}