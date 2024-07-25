import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const LandingPage = ({setEntryToAdd, setCheckForMoreDetails, setCurrentTimeFrame}) => {

    const navigate = useNavigate();

    const [isOpen, setIsOpen] = useState(false);

    const handleDropdownClick = ()=>{
        setIsOpen(!isOpen);
    };

    const handleSetEntryToAdd = (entry)=>{
        setEntryToAdd(entry);
    }; 

    const handleClickForExistingEntries = ()=>{
        setCheckForMoreDetails(null);
        navigate("/select-entry");
    };

    const handleClickForDashboard = ()=>{
        setCurrentTimeFrame(null);
        navigate("/select-time-frame");
    };

    return ( 
        <main>
            <h2>App Description</h2>
            <p>lorem ipsum</p>
            <section>
                <button onClick={handleClickForDashboard}>View Dashboard</button>
                <div className="dropdown-button">
                    <button onClick={handleDropdownClick}>Add Entry</button>
                    <div className={isOpen ? "dropdown-menu-show" : "dropdown-menu"}>
                        <ul>
                            <li><Link to="/add-entry" onClick={()=>{handleSetEntryToAdd("income")}}>Income</Link></li>
                            <li><Link to="/add-entry" onClick={()=>{handleSetEntryToAdd("expense")}}>Expense</Link></li>
                            <li><Link to="/add-entry" onClick={()=>{handleSetEntryToAdd("budget")}}>Budget</Link></li>
                            <li><Link to="/add-entry" onClick={()=>{handleSetEntryToAdd("actualSaving")}}>Actual Savings</Link></li>
                            <li><Link to="/add-entry" onClick={()=>{handleSetEntryToAdd("savingGoal")}}>Savings Goals</Link></li>
                        </ul>
                    </div>
                </div>
                <button onClick={handleClickForExistingEntries}>View/Edit/Delete Existing Entries</button>
            </section>
        </main>
     );
}
 
export default LandingPage;