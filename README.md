# OneToOne
- ![image](https://user-images.githubusercontent.com/96066271/210025211-d3939059-b820-499c-8f54-54e540e4633d.png)
# Entities
```
 public class Addres {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        private String street;
        private String zipCode;

        @OneToOne(cascade = CascadeType.PERSIST,mappedBy = "addres",fetch = FetchType.LAZY)
        private Kullanici kullanici;

} 
```
 
 ```
 public class Kullanici {// it means user spring did not let me give that name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Addres addres;

} 
```
