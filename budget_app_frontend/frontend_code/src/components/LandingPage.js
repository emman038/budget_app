import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const LandingPage = () => {

    const navigate = useNavigate();

    const [isOpen, setIsOpen] = useState(false);

    const handleDropdownClick = ()=>{
        setIsOpen(!isOpen);
    };

    return ( 
        <main>
            <h2>App Description</h2>
            <p>lorem ipsum</p>
            <section>
                <button onClick={()=>{navigate("/dashboard")}}>View Dashboard</button>
                <div className="dropdown-button">
                    <button onClick={handleDropdownClick}>Add Entry</button>
                    <div className={isOpen ? "dropdown-menu-show" : "dropdown-menu"}>
                        <ul>
                            <li><Link to="/add-entry">Income</Link></li>
                            <li><Link to="/add-entry">Expense</Link></li>
                            <li><Link to="/add-entry">Budget</Link></li>
                            <li><Link to="/add-entry">Actual Savings</Link></li>
                            <li><Link to="/add-entry">Savings Goals</Link></li>
                        </ul>
                    </div>
                </div>
                <button onClick={()=>{navigate("/select-entry")}}>View/Edit/Delete Existing Entries</button>
            </section>
        </main>
     );
}
 
export default LandingPage;