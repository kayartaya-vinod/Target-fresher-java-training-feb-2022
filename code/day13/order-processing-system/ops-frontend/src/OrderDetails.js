import React, { useState } from 'react';

function OrderDetails() {
    const [orderId, setOrderId] = useState('');
    const [order, setOrder] = useState({});
    const [errMsg, setErrMsg] = useState('');

    const handleFormSubmission = (evt) => {
        evt.preventDefault();
        const url = 'http://localhost:8080/api/orders/' + orderId;
        fetch(url)
            .then((resp) => resp.json())
            .then((resp) => {
                if (resp.status && resp.status === 404) {
                    setErrMsg(resp.message);
                    setOrder({});
                } else {
                    setOrder(resp);
                    setErrMsg('');
                }
            })
            .catch((err) => console.error(err));
    };

    const handleTextfieldChange = (evt) => {
        setOrderId(evt.target.value);
    };

    return (
        <>
            <div className='container' style={{ minHeight: '600px' }}>
                <form onSubmit={handleFormSubmission}>
                    <div>
                        <label htmlFor='orderId'>Enter order id: </label>
                        <input
                            autoFocus
                            type='text'
                            className='form-control'
                            id='orderId'
                            name='orderId'
                            value={orderId}
                            onChange={handleTextfieldChange}
                        />
                    </div>
                </form>

                <h3 className='text-danger mt-3'>{errMsg !== '' && errMsg}</h3>

                <table className='table table-bordered'>
                    <tbody>
                        <tr>
                            {order.customer && (
                                <td>
                                    <h5>
                                        Customer: {order.customer.companyName}
                                    </h5>
                                    <p>
                                        {order.customer.contactName}
                                        <br />
                                        {order.customer.city}
                                        <br />
                                        {order.customer.region}
                                        <br />
                                        {order.customer.country}
                                        <br />
                                    </p>
                                </td>
                            )}
                            {order.employee && (
                                <td>
                                    <h5>
                                        Employee: {order.employee.lastname}{' '}
                                        {order.employee.firstname}
                                    </h5>
                                    <p>
                                        {order.employee.title}
                                        <br />
                                        {order.employee.city}
                                        <br />
                                        {order.employee.region}
                                        <br />
                                        {order.employee.country}
                                        <br />
                                    </p>
                                </td>
                            )}
                            {order.shippedBy && (
                                <td>
                                    <h5>
                                        Shipped by:{' '}
                                        {order.shippedBy.companyName}
                                    </h5>
                                    <p>{order.shippedBy.phone}</p>
                                </td>
                            )}
                        </tr>
                    </tbody>
                </table>

                {/* line items here */}
                {order.lineItems && (
                    <table className='table table-striped table-bordered table-hover'>
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th>Unit price</th>
                                <th>Quantity</th>
                                <th>Discount</th>
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            {order.lineItems.map((li) => (
                                <tr key={li.product.productId}>
                                    <td>{li.product.productName}</td>
                                    <td>{li.unitPrice}</td>
                                    <td>{li.quantity}</td>
                                    <td>{li.discount * 100}%</td>
                                    <td>
                                        {li.unitPrice *
                                            li.quantity *
                                            (1 - li.discount)}
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                )}
            </div>
        </>
    );
}

export default OrderDetails;
