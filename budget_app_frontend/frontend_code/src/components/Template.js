import { useState } from "react";
import { Link, Outlet } from "react-router-dom";

const Template = ({setEntryToAdd, setCheckForMoreDetails, setCurrentTimeFrame}) => {

    const [isOpen, setIsOpen] = useState(false);

    const handleDropdownClick = ()=>{
        setIsOpen(!isOpen);
    };

    const handleSetEntryToAdd = (entry)=>{
        setEntryToAdd(entry);
    }; 

    const handleSetCheckForMoreDetails = ()=>{
        setCheckForMoreDetails(null);
    };

    const handleSetCurrentTimeFrame = ()=>{
        setCurrentTimeFrame(null);
    };

    return (
        <>
            <nav>
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/select-time-frame" onClick={handleSetCurrentTimeFrame}>View Dashboard</Link></li>
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
                    <li><Link to="/select-entry" onClick={handleSetCheckForMoreDetails}>Edit an Existing Entry</Link></li>
                </ul>
            </nav>
            <h1>Title</h1>
            <Outlet />
            <footer></footer>
        </>
    );
}

export default Template
