import axios from "axios";
import { useEffect, useState } from "react";

export default function useFetch(url)
{
    debugger;
    const [data,setData]=useState([]);

    const [refetchData,setRefetchData]=useState({});

    useEffect(()=>{
        axios.get(url)
        .then(res=>setData(res.data));
    },[url,refetchData]);

    return {data,setRefetchData};

}