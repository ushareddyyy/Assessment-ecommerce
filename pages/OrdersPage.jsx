import './OrdersPage.css';

const OrdersPage = () => {
  const handleClick = () => {
    alert('You clicked the orders box!');
  };

  return (
    <div className="order-box" onClick={handleClick}>
      Orders will be listed here.
    </div>
  );
};

export default OrdersPage;
