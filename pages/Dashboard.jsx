import { Routes, Route, useNavigate } from 'react-router-dom';
import Sidebar from '../components/Sidebar';
import Header from '../components/Header';
import OrdersPage from './OrdersPage';
import ProductsPage from './ProductsPage';

import './Dashboard.css';


const Dashboard = () => {
  const navigate = useNavigate();

  return (
    <div className="flex h-screen">
      <Sidebar />
      <div className="flex flex-col flex-1">
        <Header />
        <div className="p-6 bg-gray-100 flex-1 overflow-y-auto">
          <Routes>
            <Route path="orders" element={<OrdersPage />} />
            <Route path="products" element={<ProductsPage />} />
          </Routes>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
