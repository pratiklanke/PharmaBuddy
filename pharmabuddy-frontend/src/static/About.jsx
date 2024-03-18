import React from 'react';
import '../static/About.css';
import computer from "../images/computer.png";
import target from "../images/target.png";
import confued from "../images/confused.png";

function About() {
    return (
        <>
            <main role="main">
           
                <div className="container about_text">
                <hr />
                    <div className="row">
                        <div className="col-md-4  ">
                            <div className="text-center mt-2">
                                <img src={computer} alt={"Logo"} className="bd-placeholder-img  " width="140" height="140" />
                                <h2>Vision</h2>
                            </div>
                            <p className="text-justify">1.Accessibility: Ensure that individuals from all walks of life can easily access necessary medications and healthcare products conveniently through our website.
<br />
2.Affordability: Strive to offer competitive pricing and discounts to make healthcare products more affordable and accessible to all segments of society.
<br />
3.Reliability: Build trust among customers by maintaining high standards of product quality, authenticity, and timely delivery of orders.
                            </p>

                        </div>
                        <div className="col-md-4  ">
                            <div className="text-center mt-2">
                                <img src={target} alt={"Logo"} className="bd-placeholder-img " width="140" height="140" />
                                <h2>Mission</h2>
                            </div>
                            <p className="text-justify">
                1. Empowerment: Focus on empowering individuals to make informed decisions about their health by offering them access to a wide range of pharmaceutical products and healthcare resources.
<br />
2. Convenience: Emphasize the convenience of accessing healthcare products and services through an intuitive online platform, enabling customers to order medications and medical supplies from the comfort of their homes.
<br />
3. Quality: Commit to maintaining high standards of quality assurance to ensure that all products offered on the platform are authentic, safe, and effective for consumers.
                            </p>

                        </div>
                        <div className="col-md-4  ">
                            <div className="text-center mt-2">
                                <img src={confued} alt={"Logo"} className="bd-placeholder-img" width="140" height="140" />
                                <h2>Why Us</h2>
                            </div>
                            <p className="d-flex justify-content-start text-justify">
                           1.Convenience: With our user-friendly online platform, customers can conveniently order their medications and healthcare products from the comfort of their homes, saving them time and effort.
<br />
2. Wide Range of Products: We offer a comprehensive selection of pharmaceutical products, including prescription medications, over-the-counter drugs, wellness products, medical devices, and more, catering to diverse healthcare needs.
<br />
3. Competitive Pricing: We strive to offer competitive pricing and regular discounts, ensuring that our customers have access to affordable healthcare products without compromising on quality.

                            </p>
                        </div>
                    </div>

                    <hr />

                </div>

            </main>
        </>
    );
}

export default About;