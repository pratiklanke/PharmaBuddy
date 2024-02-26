
import Form from 'react-bootstrap/Form';
import { Button } from 'react-bootstrap';
import { useRef } from 'react';
import { useFormik } from 'formik';
export default function Login()
{

    const validateLoginForm = loginData => {
        const errors = {};
        if (!loginData.username) {
            errors.username = "Username is required";
        }
        if (!loginData.password) {
            errors.password = "Password is required";
        }
        else if (loginData.password.length < 8) {
            errors.password = "Password must be at least 8 char";
        }
        return errors;
    }

    const formik=useFormik({
        initialValues:
        {
            username:'',
            password:''
        },
        validate: validateLoginForm,
        onSubmit:
            values => {
            if(values.username==='test@gmail.com' && values.password==='test@12345')
            {
                alert('login successful');
            }
            else
            {
                alert('invalid credentials '+values.username +" "+values.password);
            }
            formik.resetForm();
        }

    })


    const element=
    <>
     <Form onSubmit={formik.handleSubmit}>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control type="email" placeholder="Enter email" id="username"
        onChange={formik.handleChange} onBlur={formik.handleBlur} value={formik.values.username} />
        {formik.touched.username && formik.errors.username ? <div>{formik.errors.username}</div> :null }
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Password" id="password" 
        onChange={formik.handleChange} value={formik.values.password}  onBlur={formik.handleBlur} />
        {formik.touched.password && formik.errors.password ? <div>{formik.errors.password}</div> :null }
      </Form.Group>
      <Button variant="primary" type="submit">Login</Button>
    </Form>
    </>

    return element


    //Uncontrolled Form
   /*  const usernameref=useRef();
    const passwordref=useRef();

     const handleSubmit=(event)=>{
        debugger;
        //event.preventDefault();
        if(usernameref.current.value==="test@gmail.com" && passwordref.current.value==="test@12345")
        { 
            alert("Login successful");
        }
        else
        {
            alert("invalid");
        }
    }


    const element=
    <>
     <Form onSubmit={handleSubmit}>
      <Form.Group className="mb-3" controlId="formGroupEmail">
        <Form.Label>Email address</Form.Label>
        <Form.Control type="email" placeholder="Enter email" ref={usernameref}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="formGroupPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Password" ref={passwordref} />
      </Form.Group>
      <Button variant="primary" type="submit">Login</Button>
    </Form>
    </>

    return element */
}