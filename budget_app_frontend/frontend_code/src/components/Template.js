import { Link, Outlet } from "react-router-dom";

const Template = () => {
    return (
        <>
            <nav>
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/select-time-frame">View Dashboard</Link></li>
                    <li><Link to="/add-entry">Add an entry</Link></li>
                    <li><Link to="/select-entry">Edit an Existing Entry</Link></li>
                </ul>
            </nav>
            <h1>Title</h1>
            <Outlet />
            <footer></footer>
        </>
    );
}
 
export default Template
