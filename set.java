import java.util.Scanner;
import reader.ReadCsv;
import logic.Logic;

interface PortfolioBackend
{
    
    static void main_menu()
    {   
        String TITLES[] = {
            "1. Add your assets in [Equity, Real Estate, Debt]", 
            "2. Calculate Net Worth in INR", 
            "3. Calculate Risk Profile",
            "4. Calculate Returns", 
            "-1. Exit"
            };

        for (String title: TITLES)
        {
            System.out.println(title);
        }

    }

    static void main_asset_menu()
    {
        String TITLES[] = {
            "1. Add Equity Assets", 
            "2. Add Real Estate Assets", 
            "3. Add Debt Assets", 
            "-1. Back"
            };

        for (String title: TITLES)
        {
            System.out.println(title);
        }              
    }

    static void specific_asset_menu(String asset_type, Logic assets)
    {
        if (asset_type.equals("equity"))
        {
            assets.all_equity_assets.print();
        }   
        else if (asset_type.equals("debt"))
        {
            assets.all_debt_assets.print();
        }   
        else if (asset_type.equals("real_estate"))
        {
            assets.all_real_estate_assets.print();
        }
        System.out.println("-1. Back");
    }
    
    static void main_worth_risk_return_menu()
    {
        String TITLES[] = {
            "1. Equity", 
            "2. Debt", 
            "3. Real Estate", 
            "4. All Portfolio",
            "-1. Back"
            };

        for (String title: TITLES)
        {
            System.out.println(title);
        }              

    }

    static int[] normalise_arraylist(int array[], int filled)
    {
        if (filled == 0)
        {
            return new int[]{};
        }

        int temp_array[] = new int[filled];

        for (int i=0; i<filled; i++)
        {
            temp_array[i] = array[i];
        }

        return temp_array;
    }

}

class set
{
    public static void main(String args[])
    {
        Logic assets = new Logic();
        int choice;
        Scanner random = new Scanner(System.in);

        while (true)
        {
            PortfolioBackend.main_menu();
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(random.nextLine());
            System.out.println("");
            if (choice == -1)
            {
                break;
            }
            else if(choice == 1)
            {
                while (true)
                {
                    int owned_assets[] = new int[10]; 
                    int owned_assets_quantity[] = new int[10];
                    int filled = 0;
                    PortfolioBackend.main_asset_menu();
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(random.nextLine());

                    if (choice == -1)
                    {
                        break;
                    }
                    else if(choice == 1)
                    {
                        System.out.println();

                        while (true)
                        {
                            PortfolioBackend.specific_asset_menu("equity", assets);
                            System.out.print("Enter your choice: ");
                            choice = Integer.parseInt(random.nextLine());
                            
                            if (choice == -1)
                            {
                                System.out.println("");
                                assets.set_assets(
                                                PortfolioBackend.normalise_arraylist(owned_assets, filled),
                                                PortfolioBackend.normalise_arraylist(owned_assets_quantity, filled),
                                                "equity"
                                                );

                                break;
                            }
                            else if (choice >= assets.all_equity_assets.total_data_list.length)
                            {
                                System.out.println("Choice Invalid");
                                System.out.println("");
                                break;
                            }
                            else
                            {
                                int quantity; 
                                System.out.print("Enter the quantity: ");
                                quantity = Integer.parseInt(random.nextLine());
                                System.out.println();
                                owned_assets[filled] = choice;
                                owned_assets_quantity[filled] = quantity;
                                filled += 1;
                            }

                        }
                    }

                    else if(choice == 2)
                    {
                        System.out.println();

                        while (true)
                        {
                            PortfolioBackend.specific_asset_menu("real_estate", assets);
                            System.out.print("Enter your choice: ");
                            choice = Integer.parseInt(random.nextLine());
                            
                            if (choice == -1)
                            {
                                System.out.println("");
                                assets.set_assets(
                                                PortfolioBackend.normalise_arraylist(owned_assets, filled),
                                                PortfolioBackend.normalise_arraylist(owned_assets_quantity, filled),
                                                "real_estate"
                                                );
                                break;
                            }
                            else if (choice >= assets.all_real_estate_assets.total_data_list.length)
                            {
                                System.out.println("Choice Invalid");
                                System.out.println("");
                                break;
                            }
                            else
                            {
                                int quantity; 
                                System.out.print("Enter the land in square metre: ");
                                quantity = Integer.parseInt(random.nextLine());
                                System.out.println();
                                owned_assets[filled] = choice;
                                owned_assets_quantity[filled] = quantity;
                                filled += 1;
                            }

                        }
                    }

                    else if(choice == 3)
                    {
                        System.out.println();

                        while (true)
                        {
                            PortfolioBackend.specific_asset_menu("debt", assets);
                            System.out.print("Enter your choice: ");
                            choice = Integer.parseInt(random.nextLine());
                            
                            if (choice == -1)
                            {
                                System.out.println("");
                                assets.set_assets(
                                                PortfolioBackend.normalise_arraylist(owned_assets, filled),
                                                PortfolioBackend.normalise_arraylist(owned_assets_quantity, filled),
                                                "debt"
                                                );
                                break;
                            }
                            else if (choice >= assets.all_debt_assets.total_data_list.length)
                            {
                                System.out.println("Choice Invalid");
                                System.out.println("");
                                break;
                            }
                            else
                            {
                                int quantity; 
                                System.out.print("Enter the quantity: ");
                                quantity = Integer.parseInt(random.nextLine());
                                System.out.println();
                                owned_assets[filled] = choice;
                                owned_assets_quantity[filled] = quantity;
                                filled += 1;
                            }

                        }
                    }

                }
            }
            else if (choice == 2)
            {
                while (true)
                {
                    PortfolioBackend.main_worth_risk_return_menu();
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(random.nextLine());

                    if (choice == -1)
                    {
                        System.out.println();
                        break;
                    }
                    
                    else if (choice == 1)
                    {
                        System.out.println();
                        System.out.println("worth of Equity is INR " + assets.get_asset_info("equity","worth"));
                        System.out.println();
                    }
                    else if (choice == 2)
                    {
                        System.out.println();
                        System.out.println("worth of Debt is INR " + assets.get_asset_info("debt","worth"));
                        System.out.println();
                    }
                    else if (choice == 3)
                    {
                        System.out.println();
                        System.out.println("worth of Real Estate is INR " + assets.get_asset_info("real_estate","worth"));
                        System.out.println();
                    }
                    else if (choice == 4)
                    {
                        System.out.println();
                        System.out.println("worth of Entire Portfolio is INR " + assets.total_assets_info("worth"));
                        System.out.println();
                    }
                }
            }
            else if (choice == 3)
            {
                while (true)
                {
                    PortfolioBackend.main_worth_risk_return_menu();
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(random.nextLine());

                    if (choice == -1)
                    {
                        System.out.println();
                        break;
                    }
                    
                    else if (choice == 1)
                    {
                        System.out.println();
                        System.out.println("risk of Equity " + assets.get_asset_info("equity","risk"));
                        if (assets.get_asset_info("equity", "risk") > 0)
                        {
                            System.out.println("This investment is of " + assets.portfolio_risk(assets.get_asset_info("equity","risk")));
                        }
                        System.out.println();
                    }
                    else if (choice == 2)
                    {
                        System.out.println();
                        System.out.println("risk of Debt " + assets.get_asset_info("debt","risk"));
                        if (assets.get_asset_info("debt", "risk") > 0)
                        {
                            System.out.println("This investment is of " + assets.portfolio_risk(assets.get_asset_info("debt","risk")));
                        }

                        System.out.println();
                    }
                    else if (choice == 3)
                    {
                        System.out.println();
                        System.out.println("risk of Real Estate " + assets.get_asset_info("real_estate","risk"));
                        if (assets.get_asset_info("real_estate", "risk") > 0)
                        {
                            System.out.println("This investment is of " + assets.portfolio_risk(assets.get_asset_info("real_estate","risk")));
                        }

                        System.out.println();
                    }
                    else if (choice == 4)
                    {
                        System.out.println();
                        System.out.println("risk of Entire Portfolio is " + assets.total_assets_info("risk"));
                        if (assets.total_assets_info("risk") > 0)
                        {
                            System.out.println("This investment is of " + assets.portfolio_risk(assets.total_assets_info("risk")));
                        }

                        System.out.println();
                    }
                }

            }
            else if (choice == 4)
            {
                while (true)
                {
                    PortfolioBackend.main_worth_risk_return_menu();
                    System.out.print("Enter your choice: ");
                    choice = Integer.parseInt(random.nextLine());

                    if (choice == -1)
                    {
                        System.out.println();
                        break;
                    }
                    
                    else if (choice == 1)
                    {
                        System.out.println();
                        System.out.println("returns of Equity in % " + assets.get_asset_info("equity","return"));
                        System.out.println();
                    }
                    else if (choice == 2)
                    {
                        System.out.println();
                        System.out.println("returns of Debt in % " + assets.get_asset_info("debt","return"));
                        System.out.println();
                    }
                    else if (choice == 3)
                    {
                        System.out.println();
                        System.out.println("returns of Real Estate in % " + assets.get_asset_info("real_estate","return"));
                        System.out.println();
                    }
                    else if (choice == 4)
                    {
                        System.out.println();
                        System.out.println("returns of Entire Portfolio in % " + assets.total_assets_info("return"));
                        System.out.println();
                    }
                }

            }

        }
    }
}