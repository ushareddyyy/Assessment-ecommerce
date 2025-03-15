import { NavLink } from 'react-router-dom';
import './Sidebar.css';

const Sidebar = () => {
  return (
    <div className="w-64 bg-blue-800 text-white flex flex-col p-4">
      <h2 className="text-2xl font-bold mb-6">Admin Panel</h2>
      <NavLink to="/dashboard/orders" className="mb-3 hover:underline">Orders</NavLink>
      <NavLink to="/dashboard/products" className="mb-3 hover:underline">Products</NavLink>
      <NavLink to="/login" className="mt-auto text-red-300 hover:underline">Logout</NavLink>
    </div>
  );
};

export default Sidebar;
