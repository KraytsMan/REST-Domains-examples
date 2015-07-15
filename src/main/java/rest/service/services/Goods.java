package rest.service.services;

public class Goods {

    private long id;

    private String name;

    private String description;

    private int amount;

    private int price;

    public Goods(GoodsBuilder builder) {
        this.id = builder.getId();
        this.name = builder.getName();
        this.description = builder.getDescription();
        this.amount = builder.getAmount();
        this.price = builder.getPrice();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }


    public static class GoodsBuilder
    {

        private long id;

        private String name;

        private String description;

        private int amount;

        private int price;

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getAmount() {
            return amount;
        }

        public int getPrice() {
            return price;
        }

        public GoodsBuilder id(long id)
        {
            this.id = id;
            return this;

        }
        public GoodsBuilder name(String name)
        {
            this.name = name;
            return this;

        }
        public GoodsBuilder description(String description)
        {
            this.description = description;
            return this;

        }
        public GoodsBuilder amount(int amount)
        {
            this.amount = amount;
            return this;

        }
        public GoodsBuilder price(int price)
        {
            this.price = price;
            return this;

        }

        public Goods build()
        {
            return new Goods(this);
        }
    }

}
