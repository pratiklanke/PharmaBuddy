import axios from "axios";
import { useCallback, useState } from "react";

export default function useDelete()
{
    const [data,setData]=useState();

    const deleteData=useCallback((url)=>{

        axios.delete(url)
        .then(res=>setData(res.data));
    },[]);

    return {data,deleteData};
}