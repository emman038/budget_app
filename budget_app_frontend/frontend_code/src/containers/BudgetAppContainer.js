import LandingPage from "../components/LandingPage";
import Template from "../components/Template";
import AddEntryForm from "../components/addEntryRouteComponents/AddEntryForm";
import Dashboard from "../components/dashboardRouteComponents/dashboardComponents/Dashboard";
import TimeFrame from "../components/dashboardRouteComponents/timeFrameComponents/TimeFrame";
import EditEntryForm from "../components/editEntryRouteComponents/editEntryFormComponents/EditEntryForm";
import SelectEntry from "../components/editEntryRouteComponents/selectEntryComponents/SelectEntry";

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { useEffect, useState } from "react";

const BudgetAppContainer = () => {

    const [listOfEntries, setListOfEntries] = useState(null);
    const [currentTimeFrame, setCurrentTimeFrame] = useState(null);
    const [dashboardEntries, setDashboardEntries] = useState(null);
    const [entryToEdit, setEntryToEdit] = useState(null);

    // Classifications are the sources and categories for the entries
    const [listOfClassifications, setListOfClassifications] = useState(null);

    const fetchEntries = async ()=>{
        const response = await fetch("http://localhost:8080/entries");
        const data = await response.json();
        setListOfEntries(data);
    };

    const fetchClassifications = async ()=>{
        const response = await fetch("http://localhost:8080/classifications")
        const data = await response.json();
        setListOfClassifications(data);
    };

    useEffect(()=>{
        fetchEntries();
        fetchClassifications();
    },[])

    const budgetAppRoutes = createBrowserRouter([
        {
            path: "/",
            element: <Template />,
            children: [
            {
                path: "/",
                element: <LandingPage/>
            },
            {
                path: "/select-time-frame",
                element: <TimeFrame/>
            },
            {
                path: "/dashboard",
                element: <Dashboard/>
            },
            {
                path: "/add-entry",
                element: <AddEntryForm listOfClassifications={listOfClassifications}/>
            },
            {
                path: "/select-entry",
                element: <SelectEntry />
            },
            {
                path: "/edit-entry",
                element: <EditEntryForm />
            }
        ]
        }
    ])

    return ( 
        <>
            <p>Container</p>
            <RouterProvider router={budgetAppRoutes} /> 
        </>
     );
}
 
export default BudgetAppContainer;