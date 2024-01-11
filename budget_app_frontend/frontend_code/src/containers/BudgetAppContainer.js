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
    const [checkForMoreDetails, setCheckForMoreDetails] = useState(null);

    const [entryToAdd, setEntryToAdd] = useState(null);

    const [listOfClassifications, setListOfClassifications] = useState(null);

    const fetchEntries = async () => {
        const response = await fetch("http://localhost:8080/entries");
        const data = await response.json();
        setListOfEntries(data);
    };

    const fetchClassifications = async () => {
        const response = await fetch("http://localhost:8080/classifications")
        const data = await response.json();
        setListOfClassifications(data);
    };

    useEffect(() => {
        fetchEntries();
        fetchClassifications();
    }, []);

    const postEntry = async (newEntry, entryType) => {
        const response = await fetch(`http://localhost:8080/${entryType}`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(newEntry)
        })

        fetchEntries();
        fetchClassifications();
    };

    const deleteEntry = async (entryId, entryType) => {
        const response = await fetch(`http://localhost:8080/${entryType}/${entryId}`, {
            method: "DELETE",
            headers: { "Content-Type": "application/json" }
        })

        fetchEntries();
        fetchClassifications();
    };

    const modifyEntry = async (newEntry, entryType) => {
        const response = await fetch(`http://localhost:8080/${entryType}`, {
            method: "PATCH",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(newEntry)
        })

        const data = await response.json();

        fetchEntries();
        fetchClassifications();
    };

    const budgetAppRoutes = createBrowserRouter([
        {
            path: "/",
            element: <Template setEntryToAdd={setEntryToAdd} setCheckForMoreDetails={setCheckForMoreDetails} />,
            children: [
                {
                    path: "/",
                    element: <LandingPage setEntryToAdd={setEntryToAdd} setCheckForMoreDetails={setCheckForMoreDetails} />
                },
                {
                    path: "/select-time-frame",
                    element: <TimeFrame />
                },
                {
                    path: "/dashboard",
                    element: <Dashboard />
                },
                {
                    path: "/add-entry",
                    element: <AddEntryForm listOfClassifications={listOfClassifications} postEntry={postEntry} entryToAdd={entryToAdd} setEntryToAdd={setEntryToAdd} />
                },
                {
                    path: "/select-entry",
                    element: <SelectEntry listOfEntries={listOfEntries} setEntryToEdit={setEntryToEdit} checkForMoreDetails={checkForMoreDetails} setCheckForMoreDetails={setCheckForMoreDetails} />
                },
                {
                    path: "/edit-entry",
                    element: <EditEntryForm entryToEdit={entryToEdit} listOfClassifications={listOfClassifications} postEntry={postEntry} deleteEntry={deleteEntry} modifyEntry={modifyEntry}/>
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