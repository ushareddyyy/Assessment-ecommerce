import { Link } from 'react-router-dom';

const HomePage = () => {
  return (
    <div className="h-screen flex flex-col items-center justify-center bg-gray-200">
      <h1 className="text-4xl font-bold mb-6">E-Commerce Admin</h1>
      <Link to="/login" className="bg-blue-600 text-white px-6 py-2 rounded hover:bg-blue-700">
        Go to Login
      </Link>
    </div>
  );
};

export default HomePage;
