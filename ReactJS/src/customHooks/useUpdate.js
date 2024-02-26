import { useState,useCallback } from "react";
import axios from "axios";
export default function useUpdate()
{
    const [data,setData]=useState([]);

    const updateData=useCallback((url,newData)=>{

        axios.put(url,newData)
        .then(res=>setData(res.data));
            
    },[]);

    return {data,updateData};
}