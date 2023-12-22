import LandingPage from "../components/LandingPage";
import Template from "../components/Template";
import AddEntryForm from "../components/addEntryRouteComponents/AddEntryForm";
import Dashboard from "../components/dashboardRouteComponents/dashboardComponents/Dashboard";
import TimeFrame from "../components/dashboardRouteComponents/timeFrameComponents/TimeFrame";
import EditEntryForm from "../components/editEntryRouteComponents/editEntryFormComponents/EditEntryForm";
import SelectEntry from "../components/editEntryRouteComponents/selectEntryComponents/SelectEntry";

import { createBrowserRouter, RouterProvider } from "react-router-dom";

const BudgetAppContainer = () => {

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
                element: <AddEntryForm />
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