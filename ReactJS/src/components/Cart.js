import { useContext } from "react";
import CartContext from "./CartContext";
import { Container, Row, Card } from "react-bootstrap";
import UpdateCart from "./UpdateCart";

export default function Cart() {
    const context = useContext(CartContext);

    const cartlistdata = context.cart;

    const element =
        <>
            <h1>This is cart component</h1>
            {cartlistdata.map(cartitem =>
                <Row style={{ width: '50%', paddingTop: '5px' }}>
                    <Card style={{ boxShadow: '5px 5px 5px grey' }}>
                        <Card.Img variant="top" src={cartitem.imagepath} height={80} width={20} />
                        <Card.Body>
                            <Card.Text>
                                Title: {cartitem.title}
                            </Card.Text>
                            <Card.Text>
                                Quantity: {cartitem.quantity}
                            </Card.Text>
                            <UpdateCart cartitem={cartitem}/>
                        </Card.Body>
                    </Card>

                </Row>

            )}
        </>

    return element;
}